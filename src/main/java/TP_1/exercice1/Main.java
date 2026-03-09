package TP_1.exercice1;

public class Main {
    public static void main(String[] args) {
        Alphabet_Runnable t1 = new Alphabet_Runnable();
        Counting_Runnable t2 = new Counting_Runnable();
        Thread thread_alphabet = new Thread(t1, "Alphabet worker");
        Thread thread_Counting = new Thread(t2, "Counting worker");
        thread_Counting.start();
        try {
            thread_Counting.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread_alphabet.start();
    }
}
