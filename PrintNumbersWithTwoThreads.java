import java.util.concurrent.locks.ReentrantLock;

public class PrintNumbersWithTwoThreads {
    private int counter = 1;
    private final int max = 10;
    private final ReentrantLock lock = new ReentrantLock();

    private void printOdd() throws InterruptedException {
        while (counter <= max) {
            lock.lock();
            try {
                if (counter % 2 == 1) {
                    System.out.println("Thread 1: " + counter++);
                }
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000);
        }
    }

    private void printEven() throws InterruptedException {
        while (counter <= max) {
            lock.lock();
            try {
                if (counter % 2 == 0) {
                    System.out.println("Thread 2: " + counter++);
                }
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        PrintNumbersWithTwoThreads printNumbersWithTwoThreads = new PrintNumbersWithTwoThreads();

        Thread thread1 = new Thread(() -> {
            try {
                printNumbersWithTwoThreads.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2  = new Thread(() -> {
            try {
                printNumbersWithTwoThreads.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}
