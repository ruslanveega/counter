package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.jupiter.api.Test;

import org.example.server.AppServer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppServerTest {

    private final AppServer appServer = new AppServer();
    @Test
    public void helloWorldTest() throws Exception {
        appServer.startServer();
        URL url = new URL("http://localhost:8080/api/hello");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Connection", "keep-alive");

        int expectedCode = 200;
        int responseCode = connection.getResponseCode();
        String expectedMessage = "Hello, world!";
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseMessage = br.readLine();

        assertEquals(expectedCode, responseCode);
        assertEquals(expectedMessage, responseMessage);
    }
}

