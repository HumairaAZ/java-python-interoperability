package com.example;

import py4j.GatewayServer;
import py4j.Py4JNetworkException;
import py4j.Py4JServerConnection;

public class PythonGateway {
    public int add(int a, int b) {
        GatewayServer gatewayServer = new GatewayServer();
        try {
            Py4JServerConnection connection = gatewayServer.getConnectionManager().getDefaultServerConnection();
            connection.start();
            Object pythonEntryPoint = connection.getPythonServerEntryPoint(new Class[] { PythonGateway.class });
            return (int) pythonEntryPoint.getClass().getMethod("add", int.class, int.class).invoke(pythonEntryPoint, a, b);
        } catch (Py4JNetworkException | ReflectiveOperationException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
