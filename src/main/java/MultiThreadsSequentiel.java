public class MultiThreadsSequentiel {
    public static void main(String[] args) {
            for (int i = 1; i < 11; i++) {
                System.out.println("Thread 1: " + i);
            }

            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Thread 2 (Letters): " + c);
            }
    }
}