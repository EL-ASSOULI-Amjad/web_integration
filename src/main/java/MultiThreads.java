public class MultiThreads {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Thread 2 (Letters): " + c);
            }
        });

        thread1.start();
        thread2.start();
    }
}