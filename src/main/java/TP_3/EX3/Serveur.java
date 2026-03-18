package TP_3.EX3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {
    public static void main(String[] args) {
        try {
            VenteService service = new VenteServiceImpl();

            Registry registry = LocateRegistry.createRegistry(8888);
            registry.rebind("VenteService", service);
            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}