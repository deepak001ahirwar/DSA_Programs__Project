package com.example.rest.calls;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestCallRunner {
    public static void main(String[] args) {
        String dummyUrl="https://dummyjson.com/users";
        System.out.println( "getRestServiceCall "+getRestServiceCall(dummyUrl));
    }
    /*1- call the URL pass the urlstr
     *2- open the connection and store into the HttpURLConnection
     *3- set the setRequestMethod ,setRequestProperty
     * 4- set the
     */

    public static  String getRestServiceCall(String urlStr){
        // Implement your REST call here and return the response as a string
        // use URL
        try {
            URL url = new URL(urlStr);
            // open connection
            HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.connect();
            // responce
            int responseCode = urlConnection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error: Unable to connect");
                throw new RuntimeException("HttpsResponse: " + responseCode);
            }else{
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder response= new StringBuilder();
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                urlConnection.disconnect();
                System.out.println("response: "+response);
                // 1- using GSon API
//                Gson gson = new Gson();
//                JsonObject jsonObject = gson.fromJson(String.valueOf(response), JsonObject.class);
//                for (JsonElement users : jsonObject.getAsJsonArray("users")) {
//                    JsonObject asJsonObject = users.getAsJsonObject();
//                    System.out.println(" ID: " + asJsonObject.get("id").getAsString());
//                    System.out.println("firstName: " + asJsonObject.get("firstName").getAsString());
//                    System.out.println("email: " + asJsonObject.get("email").getAsString());
//                    System.out.println("username: " + asJsonObject.get("username").getAsString());
//                    System.out.println("----------------------------------------");
//                    JsonObject address = asJsonObject.getAsJsonObject("address");
//                    System.out.println("City: " + address.get("city").getAsString());
//                    JsonObject company = asJsonObject.getAsJsonObject("company");
//                    System.out.println("company: " + company.toString());
//                    System.out.println("department: " + company.get("department"));
//                    JsonElement address1 = company.getAsJsonObject().get("address");
//
//                    System.out.println("address1:  " + address1.getAsJsonObject().get("address"));
//                    System.out.println("address1 state:  " + address1.getAsJsonObject().get("state"));
//                    System.out.println("   \n    ");
//                }

                // 2- Using the JSON simple library parse the string into a json object
                JSONParser parser = new JSONParser();
                JSONObject jsonObj= (JSONObject) parser.parse(String.valueOf(response));
                JSONArray jsonArray = (JSONArray) jsonObj.get("users");
                for(int i=0; i<jsonArray.size(); i++){
                    JSONObject usr = (JSONObject) jsonArray.get(i);
                    System.out.println("ID: " + usr.get("id"));
                    System.out.println("firstName: " + usr.get("firstName"));
                    System.out.println("email: " + usr.get("email"));
                    System.out.println("username: " + usr.get("username"));
                    System.out.println("----------------------------------------");
                    JSONObject address = (JSONObject) usr.get("address");
                    System.out.println("City: " + address.get("city"));
                    JSONObject company = (JSONObject) usr.get("company");
                    System.out.println("company: " + company.toString());
                    System.out.println("department: " + company.get("department"));
                    JSONObject address1 = (JSONObject) company.get("address");
                    System.out.println("address1:  " + address1.get("address"));
                    System.out.println("address1 state:  " + address1.get("state"));
                    System.out.println("      \n    ");
                }

                return "Connected successfully";
            }
        }catch ( Exception e){
            System.out.println("Invalid URL: "+e.getMessage());
            e.printStackTrace();
            return  "Not connected";
        }
    }
}
