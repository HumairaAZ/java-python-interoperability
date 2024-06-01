package com.example;

import py4j.GatewayServer;

public class JavaPythonInterop {
    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new PythonGateway());
        gatewayServer.start();
        System.out.println("Gateway Server Started");

        // Simulating Python call
        PythonGateway pythonGateway = new PythonGateway();
        int result = pythonGateway.callPython(10, 5);
        System.out.println("Result from Python: " + result);

        gatewayServer.shutdown();
    }
}
