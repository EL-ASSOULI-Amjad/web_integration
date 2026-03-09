package TP_1.exercice4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Root_Runnable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 5000; i++) {
            final int nombre = i;
            executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " : sqrt(" + nombre + ") = " + Math.sqrt(nombre));
                }
            );
        }
        executor.shutdown();
    }
}
