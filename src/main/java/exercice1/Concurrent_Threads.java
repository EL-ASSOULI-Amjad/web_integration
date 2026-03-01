package exercice1;

public class Concurrent_Threads {
    public void concurrent() {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println("Thread 2 : " + c);
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        Concurrent_Threads mt1 = new Concurrent_Threads();
        mt1.concurrent();
    }
}