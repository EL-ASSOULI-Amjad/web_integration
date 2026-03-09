package TP_1.exercice3;

public class Main {
    public static void main(String[] args) {

        File file = new File(5);

        for (int i = 1; i <= 3; i++) {
            new Thread(new Producteur(file), "Producteur-" + i).start();
        }

        for (int i = 1; i <= 2; i++) {
            new Thread(new Consommateur(file), "Consommateur-" + i).start();
        }
    }
}
