package com.example;

import py4j.GatewayServer;

public class PythonGateway {

    private static GatewayServer gatewayServer;

    public static void main(String[] args) {
        gatewayServer = new GatewayServer(new PythonGateway());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
        
        // Simulating Python call
        PythonGateway app = new PythonGateway();
        int result = app.callPython(10, 5);
        System.out.println("Result from Python: " + result);

        gatewayServer.shutdown();
    }

    public int callPython(int a, int b) {
        // Assuming the Python script is running and waiting for input
        JavaGatewayApp app = new JavaGatewayApp();
        return app.add(a, b);
    }

    // Java interface for Python function
    public int add(int a, int b) {
        return a + b;
    }
}
