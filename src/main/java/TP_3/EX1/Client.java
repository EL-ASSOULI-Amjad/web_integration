package TP_3.EX1;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 8888);
            FibonacciService service = (FibonacciService) registry.lookup("FibonacciService");
            int n = 6;
            int result = service.fibonacci(n);
            System.out.println("Fibonacci(" + n + ") = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}