import java.util.concurrent.atomic.AtomicInteger;

public class SyncCounter {
    private long counter;

    public static void main(String[] args) {
        SyncCounter sc = new SyncCounter();
        System.out.println(sc.get());
        sc.inc();
        System.out.println(sc.get());


        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sc.inc();
                System.out.println("Incremented: " + sc.get());
                try {
                    Thread.sleep(100); // Simulace práce vlákna a usnutí
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread readThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Read: " + sc.get());
                try {
                    Thread.sleep(150); // Simulace práce vlákna a delšího čekání
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        incrementThread.start();
        readThread.start();


    }

    public synchronized long get() {
        return counter;
    }

    public synchronized void inc() {
        counter++;
    }
}
