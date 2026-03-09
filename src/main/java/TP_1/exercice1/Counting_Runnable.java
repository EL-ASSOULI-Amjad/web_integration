package TP_1.exercice1;

public class Counting_Runnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread 1: " + i);
        }
    }
}
