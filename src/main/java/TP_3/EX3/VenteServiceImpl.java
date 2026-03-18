package TP_3.EX3;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

public class VenteServiceImpl extends UnicastRemoteObject implements VenteService {

    private List<Vente> ventes;

    protected VenteServiceImpl() throws RemoteException {
        ventes = new ArrayList<>();
        ventes.add(new Vente(1, "Mac", "US", 1600, new Date()));
        ventes.add(new Vente(2, "Phone", "US", 600, new Date()));
        ventes.add(new Vente(3, "Mac", "EU", 1700, new Date()));
    }

    public void ajouterVente(Vente v) {
        ventes.add(v);
    }

    public double chiffreAffairesTotal() {
        double total = 0;
        for (Vente v : ventes) {
            total += v.getAmount();
        }
        return total;
    }

    public Map<String, Double> chiffreAffairesParRegion() {
        Map<String, Double> map = new HashMap<>();

        for (Vente v : ventes) {
            map.put(v.getRegion(),
                    map.getOrDefault(v.getRegion(), 0.0) + v.getAmount());
        }

        return map;
    }

    public String produitPlusVendu() {
        Map<String, Integer> count = new HashMap<>();

        for (Vente v : ventes) {
            count.put(v.getProduct(),
                    count.getOrDefault(v.getProduct(), 0) + 1);
        }

        return Collections.max(count.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }

    public List<Vente> ventesSuperieures(double montant) {
        List<Vente> result = new ArrayList<>();

        for (Vente v : ventes) {
            if (v.getAmount() > montant) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vente> toutesLesVentes() {
        return ventes;
    }
}