package exercice2;

public class Compte {
    private double solde;
    private String nom;

    public double getSolde() {
        return solde;
    }

    public String getNom() {
        return nom;
    }

    public Compte(String nom, double solde){
        this.solde = solde;
        this.nom = nom;
    }

    public void retirer(int montant){
        if (solde >= montant)
        solde = solde - montant;
        else System.out.println("Montant invalide !");
    }
}
