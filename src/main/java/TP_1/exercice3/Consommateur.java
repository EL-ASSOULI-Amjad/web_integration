package TP_1.exercice3;

public class Consommateur implements Runnable {
    private File file;

    public Consommateur(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            while (true) {
                file.retirer();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
