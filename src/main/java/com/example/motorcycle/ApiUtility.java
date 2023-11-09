package com.example.motorcycle;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiUtility {
    public static ApiResponse getDataFromFile(String fileName){
        ApiResponse response = null;
        Gson gson = new Gson();

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        ){
            response = gson.fromJson(jsonReader,ApiResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
    /*
    This method will create objects but without storing it to our hard disk
     */
    public static ApiResponse getDataFromAPIQuick(String searchMake, String searchModel){

        //Delete the space in the text field
        searchMake = searchMake.replaceAll(" ", "-");
        searchModel = searchModel.replaceAll(" ","");

        String uri = "https://api.api-ninjas.com/v1/motorcycles?make=" + searchMake +"&model="+ searchModel;
        String apiKey = "lMZ1I4U6ZcR7YHtFfhZGHLKJlDXNMfXuHlUc3CKe";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("X-Api-Key", apiKey)
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}