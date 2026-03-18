package TP_3.EX2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueService extends Remote {
    double consulterSolde(int id) throws RemoteException;
    void retirer(int id, double montant) throws RemoteException;
    void transferer(int idSource, int idDest, double montant) throws RemoteException;
    String getNomClient(int id) throws RemoteException;
    Compte getCompte(int id) throws RemoteException;
}