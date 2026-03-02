package exercice4;

import java.util.*;
import java.util.concurrent.*;

public class Root_Callable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<List<String>>> listeFutures = new ArrayList<>();
        double startTime = System.currentTimeMillis();

        for (int i = 0; i <= 5000; i ++) {
            listeFutures.add(executor.submit(new RootTask(i, Math.min(i + 99, 5000))));
        }
        for (Future<List<String>> future : listeFutures) {
            List<String> res = future.get();
            for (String s : res) System.out.println(s);
        }
        executor.shutdown();
        double endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution Callable : " + (endTime - startTime) + " ms");
    }
}