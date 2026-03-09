package TP_1.exercice1;

public class Sequentiel_Threads {
    public void sequentiel() {
        for (int i = 1; i < 11; i++) {
            System.out.println("Thread 1: " + i);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println("Thread 2: " + c);
        }
    }
    public static void main(String[] args) {
        Sequentiel_Threads mt2 = new Sequentiel_Threads();
        mt2.sequentiel();
    }
}
