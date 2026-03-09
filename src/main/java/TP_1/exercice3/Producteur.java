package TP_1.exercice3;

import java.util.concurrent.ThreadLocalRandom;

public class Producteur implements Runnable{
    private File file;

    public Producteur(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = ThreadLocalRandom.current().nextInt(100);
                file.deposer(item);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
