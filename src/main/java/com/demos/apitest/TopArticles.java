package com.demos.apitest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.*;
import java.util.stream.Collectors;
import java.net.URL;
import java.util.Map.Entry;

public class TopArticles {

    private static final String URL = "https://jsonmock.hackerrank.com/api/articles";

    public static void main(String[] args) throws IOException, ParseException {
        int records = 2;

        List<String> titles = getArticles();
//        Map<String,Integer> sortedMap =
//                titles.entrySet().stream()
//                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
//                                (e1, e2) -> e1, LinkedHashMap::new));
//        List<String> keyList=new LinkedList<>(sortedMap.keySet());

        for (String title : titles) {
            System.out.println(title);
        }
    }


    private static List<String> getArticles() throws IOException, ParseException {
        List<String> titles = new ArrayList<>();
        int page = 1;
        int totalPage = 1;
        String response;

        while (page <= totalPage) {
            URL url = new URL(URL + "?page=" + page);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);


            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                informationString.append(scanner.nextLine());
            }
            //Close the scanner
            scanner.close();

            //System.out.println("API Response :: " + informationString);


            //JSON simple library Setup with Maven is used to convert strings to JSON
            JSONParser parse = new JSONParser();
            //JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

            //Get the first JSON object in the JSON array
            //System.out.println(dataObject.get(0));

            //JSONObject countryData = (JSONObject) dataObject.get(0);
            JSONObject articles = new JSONObject();
            try {
                articles = (JSONObject) parse.parse(String.valueOf(informationString));
            }
            catch (Exception ex){
                throw new ParseException(ex.hashCode());
            }
            JSONArray data = (JSONArray) articles.get("data");


            Iterator i = data.iterator();
            // take each value from the json array separately
            while (i.hasNext()) {
                totalPage = Integer.parseInt(String.valueOf((Long)articles.get("total_pages")));
                JSONObject innerObj = (JSONObject) i.next();
                String titleElem = innerObj.get("title") != null ? (String) innerObj.get("title") : innerObj.get("story_title") != null ? (String) innerObj.get("story_title") : null;

                if(titleElem != null){
                    int numComments = articles.get("num_comments") != null ? Integer.parseInt(String.valueOf((Long)articles.get("num_comments"))) : 0;;
                    //int comments_count=numComments  ? 0 : commentEle.getAsInt();
                    titles.add(titleElem);
                }
            }


            page++;
        }
        return titles;
    }
}

