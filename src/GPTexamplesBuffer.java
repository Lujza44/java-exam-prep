import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GPTexamplesBuffer {

    // Buffer with a maximum capacity of 5 elements
    private static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        // Creating producer and consumer threads
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        // Starting the threads
        producerThread.start();
        consumerThread.start();
    }

    // Producer thread to write to the buffer
    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    // Simulating some producer activity
                    Thread.sleep(500);

                    // Writing to the buffer
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Consumer thread to read from the buffer
    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    // Simulating some consumer activity
                    Thread.sleep(800);

                    // Reading from the buffer
                    int value = buffer.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


