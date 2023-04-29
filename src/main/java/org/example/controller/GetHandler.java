package org.example.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.repository.CountersRepository;

import java.io.IOException;
import java.io.OutputStream;

public class GetHandler implements HttpHandler {

    private final CountersRepository countersRepository;

    public GetHandler(CountersRepository countersRepository) {
        this.countersRepository = countersRepository;
    }

    public void handle(HttpExchange exchange) throws IOException {
        String name = exchange.getRequestURI().getQuery().split("=")[1];
        String response;
        if (name != null) {
            if (countersRepository.counters.get(Integer.valueOf(name)) != null)
                response = countersRepository.getCounterByld(Integer.valueOf(name)).toString();
            else
                response = String.format("Not such counter with id = %s", name);
        }
        else
            response = countersRepository.getAllCounters().toString();
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
