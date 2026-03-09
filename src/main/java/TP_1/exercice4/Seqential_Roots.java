package TP_1.exercice4;

public class Seqential_Roots {
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        for (int i = 0; i <= 5000; i++) {
            double r = Math.sqrt(i);
            System.out.println("sqrt(" + i + ") = " + r);
        }
        double end = System.currentTimeMillis();
        System.out.println("Temps  = " + (end - start) + " ms");
    }
}