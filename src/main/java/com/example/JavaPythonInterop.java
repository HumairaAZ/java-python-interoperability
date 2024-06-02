package com.example;

import py4j.GatewayServer;

public class JavaPythonInterop {
    public static void main(String[] args) {
        // Start the GatewayServer for Python to connect
        GatewayServer gatewayServer = new GatewayServer(new JavaPythonInterop());
        gatewayServer.start();
        System.out.println("Gateway Server Started");

        // Connect to the Python gateway and call the Python function
        try {
            Thread.sleep(2000);  // Wait for Python script to start
            System.out.println("Connecting to Python...");

            JavaPythonInterop app = new JavaPythonInterop();
            int result = app.callPythonAdd(10, 5);
            System.out.println("Result from Python: " + result);

            gatewayServer.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int callPythonAdd(int a, int b) {
        // This method would call the Python function via the gateway
        return 0;  // Placeholder return value
    }
}
