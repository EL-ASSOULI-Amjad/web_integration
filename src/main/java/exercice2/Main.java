package exercice2;

public class Main {
    public static void main(String[] args) {
        Compte compteCommun = new Compte("AhmedFatima", 1000);

        JobAhmedEtFatima job = new JobAhmedEtFatima(compteCommun);

        Thread ahmed = new Thread(job, "Ahmed");
        Thread fatima = new Thread(job, "Fatima");

        ahmed.start();
        fatima.start();
    }
}
