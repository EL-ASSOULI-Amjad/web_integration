public class Thread1_Runnable implements Runnable{
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread 1: " + i);
        }
    }
}
