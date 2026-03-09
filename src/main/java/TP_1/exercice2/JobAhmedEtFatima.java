package TP_1.exercice2;

public class JobAhmedEtFatima implements Runnable {
    private final Compte compte;

    public JobAhmedEtFatima(Compte compte) {
        this.compte = compte;
    }

    private void doRetrait(int montant) {
            String nom = Thread.currentThread().getName();
            if (compte.getSolde() >= montant) {
                System.out.println(nom + " vérifie le solde: " + compte.getSolde() + " Retrait possible " + montant);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                compte.retirer(montant);
                System.out.println(nom + " a retiré " + montant + " | Nouveau solde: " + compte.getSolde());
            } else {
                System.out.println(nom + " veut retirer " + montant + " mais solde insuffisant: " + compte.getSolde());
            }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            doRetrait(10);
        }
    }
}