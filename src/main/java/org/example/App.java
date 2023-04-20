package org.example;

import org.example.server.AppServer;

public class App
{
    public static void main(String[] args ) {
        AppServer appServer = new AppServer();
        appServer.startServer();
    }
}
