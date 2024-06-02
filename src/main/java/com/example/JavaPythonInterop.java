package com.example;

import py4j.GatewayServer;

public class JavaPythonInterop {
    public static void main(String[] args) {
        // Start the GatewayServer for Python to connect
        GatewayServer gatewayServer = new GatewayServer(new JavaPythonInterop());
        gatewayServer.start();
        System.out.println("Gateway Server Started");

        // Connect to the Python gateway
        try {
            Thread.sleep(2000);  // Wait for Python script to start
            System.out.println("Connecting to Python...");

            py4j.GatewayServer pyGateway = new py4j.GatewayServer();
            pyGateway.start();

            PythonEntryPoint pythonEntryPoint = (PythonEntryPoint) pyGateway.getPythonServerEntryPoint(new Class[] { PythonEntryPoint.class });
            int result = pythonEntryPoint.add(10, 5);
            System.out.println("Result from Python: " + result);

            gatewayServer.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public int add(int a, int b) {
        return a + b; // Simple Java method to be called from Python if needed
    }
}
