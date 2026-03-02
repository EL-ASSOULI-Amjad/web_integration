package exercice4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class RootTask implements Callable<List<String>> {
    private int debut, fin;
    public RootTask(int debut, int fin) { this.debut = debut; this.fin = fin; }
    @Override
    public List<String> call() {
        List<String> resultats = new ArrayList<>();
        for (int i = debut; i <= fin; i++) {
            resultats.add("Racine de " + i + " = " + Math.sqrt(i));
        }
        return resultats;
    }
}
