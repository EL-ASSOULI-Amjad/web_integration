package TP_3.EX1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            FibonacciService service = new FibonacciServiceImpl();
            Registry registry = LocateRegistry.createRegistry(8888);
            registry.rebind("FibonacciService", service);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}