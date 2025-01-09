import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class GPTexamplesPrimes {

    public static void main(String[] args) {
        int start = 10;
        int stop = 30;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        PrimeCounterTask task = new PrimeCounterTask(start, stop);
        int count = forkJoinPool.invoke(task);

        System.out.println("Number of prime numbers between " + start + " and " + stop + ": " + count);
    }

    static class PrimeCounterTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 5; // Adjust the threshold as needed
        private final int start;
        private final int stop;

        public PrimeCounterTask(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        protected Integer compute() {
            if (stop - start <= THRESHOLD) {
                // If the range is small enough, count primes sequentially
                return countPrimesInRange(start, stop);
            } else {
                // Split the range into two halves and invoke parallel tasks
                int mid = (start + stop) / 2;
                PrimeCounterTask leftTask = new PrimeCounterTask(start, mid);
                PrimeCounterTask rightTask = new PrimeCounterTask(mid + 1, stop);

                invokeAll(leftTask, rightTask);

                // Combine the results of both tasks
                return leftTask.join() + rightTask.join();
            }
        }

        private int countPrimesInRange(int start, int stop) {
            int count = 0;
            for (int i = start; i <= stop; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int number) {
            if (number < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

