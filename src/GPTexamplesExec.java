import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GPTexamplesExec {

    public static void main(String[] args) {
        // Create an ExecutorSevice with a fixed-size thread pool
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            executorService.execute(() -> System.out.println("Task 1 executed"));
            executorService.execute(() -> System.out.println("Task 2 executed"));
            executorService.execute(() -> System.out.println("Task 3 executed"));
            // lambda vyraz implementujuci jedinu metodu Runnable (run)

            // Submit tasks to the executor (concurrently)
            executorService.execute(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Task 1 - Iteration " + i);
                }
            });

            executorService.execute(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Task 2 - Iteration " + i);
                }
            });

            executorService.execute(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Task 3 - Iteration " + i);
                }
            });

            // Shutdown the executor when it's no longer needed
            executorService.shutdown();
        }
    }
}

