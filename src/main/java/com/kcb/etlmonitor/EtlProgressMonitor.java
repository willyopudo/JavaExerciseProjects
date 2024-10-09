package com.kcb.etlmonitor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import java.io.*;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EtlProgressMonitor {
    // JDBC URL, username, and password of Oracle database server
    private static final String JDBC_URL = readConfigValue("db.url"); // Example: replace with your DB details
    private static final String DB_USER = readConfigValue("db.user");
    private static final String DB_PASSWORD = readConfigValue("db.password");

    // API endpoint
    private static final String API_URL = readConfigValue("sms.gateway.url"); // Replace with your API endpoint

    private static final String CONFIG_FILE_PATH = "C:\\Users\\ken206312\\IdeaProjects\\JavaExerciseProjects\\src\\main\\java\\com\\kcb\\etlmonitor\\config.properties"; //Replace with your properties file path

    private static final Logger logger = Logger.getLogger(EtlProgressMonitor.class.getName());

    static {
        try {
            // Setup the file handler to rotate daily with a maximum of 7 files
            FileHandler fileHandler = new FileHandler(readConfigValue("log.dir") + "app-etlprogress-%u-%g.log", 2097152, 7, true);
            System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL); // Log all levels

            // Add the file handler to the logger
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger handler.", e);
        }
    }

    // Logging function
    public static void logMessage(String message, Level level) {
        logger.log(level, message);
    }

    public static void main(String[] args) {
        // Specify the file path
        String contactsFilePath = readConfigValue("path.contacts"); // Replace with your file path

        // Read file content into a List of Strings
        List<String> lines = readFileToStringList(contactsFilePath);
        String key = "run.iscomplete";
        String isRunCompleteVal = readConfigValue(key) != null ? readConfigValue(key) : "0";
        String alertAdminCount = readConfigValue("alert.admin.counter") != null ? readConfigValue("alert.admin.counter") : "0";
        String alertAdminPhone = readConfigValue("alert.admin.phone") != null ? readConfigValue("alert.admin.phone") : "254000000000";
        //System.out.println("Read value: " + isRunCompleteVal);

        Map<String, Integer> lastRunStatusCount = new HashMap<String, Integer>();
        lastRunStatusCount.put("NULL", 0);
        lastRunStatusCount.put("Success", 0);
        lastRunStatusCount.put("Failed", 0);


        // Initialize database connection
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            //logMessage("Connected to the database.", Level.INFO);

            // Query the Oracle table
            String query = "SELECT COUNT(*) AS total_count, nvl(LAST_RUN_STATUS, 'NULL') AS last_run_status FROM STAGING.EC_MASTER_REPORTS GROUP BY LAST_RUN_STATUS"; // Replace with your query
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                //statement.setString(1, "some_value"); // Replace with your condition value

                ResultSet resultSet = statement.executeQuery();
                //logMessage("Query executed successfully.", Level.INFO);

                // Process results
                StringBuilder sb = new StringBuilder();
                while (resultSet.next()) {
                    String total = resultSet.getString("total_count");
                    String runStatus = resultSet.getString("last_run_status");

                    String logEntry = runStatus + " : " + total + ", ";
                    sb.append(logEntry);

                    lastRunStatusCount.put(runStatus, Integer.parseInt(total));

                }
                logMessage(sb.substring(0, sb.toString().length()-2), Level.INFO);
                //mock
                lastRunStatusCount.put("NULL", 239);
                lastRunStatusCount.put("Success", 2);
                //lastRunStatusCount.put("Failed", 1);
                SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyy HH:mm");
                if(!lastRunStatusCount.isEmpty()) {

                    int totalSuccess = lastRunStatusCount.getOrDefault("Success", 0);
                    int totalFailed = lastRunStatusCount.getOrDefault("Failed", 0);
                    int totalNull = lastRunStatusCount.getOrDefault("NULL", 0);

                    if(totalSuccess + totalFailed > 0 && isRunCompleteVal.equals("0")) {
                        // Call the SMS REST API for each mobile number
                        for (String line : lines) {
                            Date dNow = new Date();
                            String failedCount = totalFailed > 0 ? "\\nFailed: " + totalFailed : "";
                            //Send alert to admin in a wider time interval using admin phone and alertAdminCounter settings in config file
                            if(line.equals(alertAdminPhone) && Integer.parseInt(alertAdminCount) % 10 != 0)
                                continue;
                            System.out.println("SMS alert sent to " + line);
                            //callRestApi(line, "Monitoring alert: EDWH Reports status\\nCurrent Count: " + totalSuccess + failedCount + "\\nTime: " + ft.format(dNow));
                        }
                        //Increment admin alter counter
                        writeConfigValue("alert.admin.counter", String.valueOf(Integer.parseInt(alertAdminCount) + 1));

                    }
                    if(totalNull == 0 && !isRunCompleteVal.equals("1")) {
                        writeConfigValue(key, "1");
                    }
                    if(totalSuccess + totalFailed == 0 && !isRunCompleteVal.equals("0")) {
                        //Reset config values
                        writeConfigValue(key, "0");
                        writeConfigValue("alert.admin.counter", "0");
                    }

                }

            } catch (SQLException e) {
                logMessage("Error while executing query: " + e.getMessage(), Level.SEVERE);
            }
        } catch (SQLException e) {
            logMessage("Database connection failed: " + e.getMessage(), Level.SEVERE);
        }
    }

    // Function to call a REST API with data from Oracle
    private static void callRestApi(String recipient, String messageData) {
        // Build the full URL with encoded parameters
//        String fullUrl = String.format("%s&recipient=%s&messagedata=%s",
//                API_URL,
//                URLEncoder.encode(recipient, StandardCharsets.UTF_8),
//                URLEncoder.encode(messageData, StandardCharsets.UTF_8));
        try {
            var trustManager = new X509ExtendedTrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
                }
            };
            var sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            // Create HttpClient
            HttpResponse<String> response;
            try (HttpClient client = HttpClient.newBuilder().sslContext(sslContext).build()) {

                String jsonReq = "{\"from\":\"KCB M-PESA\", \"to\":\"" + recipient + "\", \"message\":\"" + messageData + "\"}";

                // Create the HTTP request
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(API_URL))
                        .header("Content-Type", "application/json")
                        .header("Authorization","Bearer " + readConfigValue("sms.gateway.token"))
                        .POST(HttpRequest.BodyPublishers.ofString(jsonReq))
                        //.GET()
                        .build();

                // Send the request and get the response
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }

            // Handle the response based on status code
            handleApiResponse(response);

        } catch (IOException e) {
            logMessage("Network error occurred: " + e.getMessage(), Level.SEVERE);
        } catch (InterruptedException e) {
            logMessage("Request was interrupted: " + e.getMessage(), Level.SEVERE);
            Thread.currentThread().interrupt(); // Restore interrupt status
        } catch (Exception e) {
            logMessage("An unexpected error occurred: " + e.getMessage(), Level.SEVERE);
        }
    }

    // Method to handle API response
    private static void handleApiResponse(HttpResponse<String> response) {
        int statusCode = response.statusCode();
        String responseBody = response.body();

        switch (statusCode) {
            case 200, 201:
                logMessage("Success: " + responseBody, Level.INFO);
                break;
            case 400:
                logMessage("Bad Request: " + responseBody, Level.SEVERE);
                break;
            case 401:
                logMessage("Unauthorized: Please check API credentials." + responseBody, Level.SEVERE);
                break;
            case 404:
                logMessage("Not Found: The requested resource was not found." + responseBody, Level.SEVERE);
                break;
            case 500:
                logMessage("Internal Server Error: " + responseBody, Level.SEVERE);
                break;
            default:
                logMessage("Unexpected response: " + statusCode + " - " + responseBody, Level.SEVERE);
                break;
        }
    }

    // Method to read file content into a List of Strings
    public static List<String> readFileToStringList(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.startsWith("#"))
                    lines.add(line.split("-")[0]);
            }
        } catch (IOException e) {
            logMessage("Error reading the file: " + e.getMessage(), Level.SEVERE);
        }
        return lines;
    }

    public static String readConfigValue(String key) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error reading the configuration file: " + e.getMessage());
            return null;
        }
    }

    // Method to write a configuration value by key
    public static void writeConfigValue(String key, String value) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            // Load existing properties
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading existing configuration file: " + e.getMessage());
        }

        // Set the property value
        properties.setProperty(key, value);

        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE_PATH)) {
            // Save properties back to the file
            properties.store(output, null);
        } catch (IOException e) {
            System.err.println("Error writing to the configuration file: " + e.getMessage());
        }
    }
    //Crontab entry
    //*/20 * * * * /usr/bin/java -cp /opt/oracle/libs/ojdbc8.jar:/home/user/myapp/classes MyApp >> /home/user/myapp/logs/output.log 2>&1

}
