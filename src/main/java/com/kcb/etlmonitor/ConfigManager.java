package com.kcb.etlmonitor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final String CONFIG_FILE_PATH = "C:\\Users\\ken206312\\IdeaProjects\\JavaExerciseProjects\\src\\main\\java\\com\\kcb\\etlmonitor\\config.properties"; // Path to your properties file

    public static void main(String[] args) {
        // Example usage
        String key = "api.url";

        // Reading a configuration value
        String value = readConfigValue(key);
        System.out.println("Read value: " + value);

        // Writing a configuration value
        writeConfigValue(key, "https://newapi.example.com");
        System.out.println("Updated value for key '" + key + "' to 'https://newapi.example.com'");
    }

    // Method to read a configuration value by key
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
}

