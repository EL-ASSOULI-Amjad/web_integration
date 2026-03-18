package TP_3.EX3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            VenteService service = (VenteService) registry.lookup("VenteService");
            System.out.println("CA Total: " + service.chiffreAffairesTotal());
            System.out.println("Produit le plus vendu: " + service.produitPlusVendu());
            System.out.println("CA par région: " + service.chiffreAffairesParRegion());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
