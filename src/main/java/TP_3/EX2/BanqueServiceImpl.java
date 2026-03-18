package TP_3.EX2;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;

public class BanqueServiceImpl extends UnicastRemoteObject implements BanqueService {
    private HashMap<Integer, Compte> comptes;

    protected BanqueServiceImpl() throws RemoteException {
        comptes = new HashMap<>();
        comptes.put(1, new Compte(1, "Omar", 8000));
        comptes.put(2, new Compte(2, "Oumaima", 5000));
    }

    public double consulterSolde(int id) {
        return comptes.get(id).getSolde();
    }
    public void retirer(int id, double montant) {
        Compte c = comptes.get(id);
        c.setSolde(c.getSolde() - montant);
    }

    public void transferer(int idSource, int idDest, double montant) {
        retirer(idSource, montant);
        Compte dest = comptes.get(idDest);
        dest.setSolde(dest.getSolde() + montant);
    }

    public String getNomClient(int id) {
        return comptes.get(id).getNom();
    }
    public Compte getCompte(int id) {
        return comptes.get(id);
    }
}