package com.example;

import py4j.GatewayServer;

public class JavaPythonInterop {
    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new PythonEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");

        // Create a connection to the Python server
        py4j.GatewayServer gateway = new py4j.GatewayServer();
        gateway.start();

        // Simulating Python call
        PythonEntryPoint pythonEntryPoint = gateway.getPythonServerEntryPoint(new Class[]{PythonEntryPoint.class});
        int result = pythonEntryPoint.add(10, 5);
        System.out.println("Result from Python: " + result);

        gatewayServer.shutdown();
    }
}
