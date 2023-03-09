package com.oi.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;
// import com.hash.app.Client;

/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().build();

        Map<String, Object> rawBody = new HashMap<>();
        rawBody.put("protection_id", "5f77f9c2-2800-4661-b479-a0791aa0eacc");
        rawBody.put("ttl", 1);
        BodyPublisher body = BodyPublishers.ofString(gson.toJson(rawBody));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://backend1.kastela.duckdns.org/api/secure-channel/init"))
                .POST(body).header("Content-Type", "application/json").build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        // Map<String, Object> result = gson.fromJson(response.body(), new TypeToken<Map<String, Object>>() {
        // }.getType());

        // Client client = new Client("http://server1.kastela.duckdns.org:3201");
        // Map<String, Object> sendResult = client.secureChannelSend(result.get("credential").toString(),
        //         "disyam@hash.id");
        // System.out.println(sendResult);
    }
}
