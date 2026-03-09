package TP_1.exercice4;

import java.util.*;
import java.util.concurrent.*;

public class Root_Callable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> listeFutures = new ArrayList<>();
        double startTime = System.currentTimeMillis();

        for (int i = 0; i <= 5000; i++) {
            final int n = i;
            listeFutures.add(executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Racine de " + n + " = " + Math.sqrt(n);
                }
            }));
        }
        for (Future<String> future : listeFutures) {
            System.out.println(future.get());
        }
        executor.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution Callable : " + (endTime - startTime) + " ms");
    }
}