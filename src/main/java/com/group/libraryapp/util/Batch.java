package com.group.libraryapp.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Batch {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            String url = "https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0";
            HttpGet request = new HttpGet(new URI(url));

            CloseableHttpResponse response = httpClient.execute(request);
            try {
                // Check if response is successful (status code 200)
                if (response.getStatusLine().getStatusCode() == 200) {
                    // Read response content
                    String responseBody = EntityUtils.toString(response.getEntity());
                    System.out.println(responseBody);
                } else {
                    System.err.println("Request failed with status code: " + response.getStatusLine().getStatusCode());
                }
            } finally {
                response.close();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    public static void main(String[] args) {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        try {
//            String url = "https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0";
//            HttpGet request = new HttpGet(new URI(url));
//
//            CloseableHttpResponse response = httpClient.execute(request);
//            try {
//                // Check if response is successful (status code 200)
//                if (response.getStatusLine().getStatusCode() == 200) {
//                    // Read response content
//                    String responseBody = EntityUtils.toString(response.getEntity());
//
//                    // Parse JSON response
//                    JsonElement jsonElement = JsonParser.parse(responseBody);
//                    JsonObject jsonResponse = jsonElement.getAsJsonObject();
//
//                    // Extract images_result
//                    JsonElement imagesResult = jsonResponse.getAsJsonArray("images_results");
//                    System.out.println(imagesResult);
//                } else {
//                    System.err.println("Request failed with status code: " + response.getStatusLine().getStatusCode());
//                }
//            } finally {
//                response.close();
//            }
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                httpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}


