package TP_1.exercice3;
import java.util.LinkedList;

public class File {
    LinkedList<Integer> buffer = new LinkedList<>();
    int capacite = 7;

    public File(int capacite) {
        this.capacite = capacite;
    }
    public synchronized void deposer(int item){
        while (buffer.size() == capacite) {
            try { wait();}
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
        buffer.add(item);
        System.out.println(Thread.currentThread().getName() + " a produit: " + item + " | taille=" + buffer.size());
        notifyAll();
    }

    public synchronized int retirer(){
        while (buffer.isEmpty()) {
            try { wait();}
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
               break;
            }
        }
        int produit = buffer.removeFirst();
        System.out.println(Thread.currentThread().getName() + " a consommé: " + produit + " | taille=" + buffer.size());
        notifyAll();
        return produit;
    }

}
