from py4j.java_gateway import JavaGateway, GatewayParameters, CallbackServerParameters

class PythonEntryPoint:
    def add(self, a, b):
        return a + b

if __name__ == "__main__":
    gateway = JavaGateway(
        gateway_parameters=GatewayParameters(port=25333),
        callback_server_parameters=CallbackServerParameters(port=25334)
    )
    python_entry_point = PythonEntryPoint()
    gateway.java_gateway_server.resetCallbackClient(gateway.java_gateway_server.getCallbackClient())
    print("Python server started and waiting for calls...")

   
