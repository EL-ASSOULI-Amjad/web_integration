package TP_3.EX2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {
    public static void main(String[] args) {
        try {
            BanqueService service = new BanqueServiceImpl();
            Registry registry = LocateRegistry.createRegistry(8888);
            registry.rebind("BanqueService", service);
            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}