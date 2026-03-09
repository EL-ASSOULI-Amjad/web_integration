package TP_1.exercice1;

public class Alphabet_Runnable implements Runnable {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println("Thread 2: " + c);
        }
    }
}
