package com.example;

import py4j.GatewayServer;

public class JavaPythonInterop {
    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new JavaPythonInterop());
        gatewayServer.start();
        System.out.println("Gateway Server Started");

        // Assuming the Python script is running and waiting for input
        System.out.println("Calling Python function...");
        PythonGateway pythonGateway = new PythonGateway();
        int result = pythonGateway.add(10, 5);
        System.out.println("Result from Python: " + result);

        gatewayServer.shutdown();
    }

    public int add(int a, int b) {
        return a + b;
    }
}
