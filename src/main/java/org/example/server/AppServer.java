package org.example.server;

import com.sun.net.httpserver.HttpServer;
import org.example.controller.*;
import org.example.repository.CountersRepository;

import java.io.IOException;
import java.net.InetSocketAddress;

public class AppServer {
    private static final int DEFAULT_PORT = 8080;
    private static final int DEFAULT_BACKLOG = 0;

    public void startServer() {
        try {
            final CountersRepository countersRepository = new CountersRepository();
            HttpServer server = HttpServer.create(new InetSocketAddress(DEFAULT_PORT), DEFAULT_BACKLOG);
            server.createContext("/api/hello", new HelloHandler());
            server.createContext("/api/counters", new CountersHandler(countersRepository));
            server.createContext("/api/get", new GetHandler(countersRepository));
            server.createContext("/api/increment", new IncrementHandler(countersRepository));
            server.createContext("/api/create", new CreateHandler(countersRepository));
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("server started");
    }
}
