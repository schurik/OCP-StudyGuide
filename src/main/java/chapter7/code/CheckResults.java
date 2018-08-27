package chapter7.code;

import java.util.concurrent.*;

public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();

            // using Runnable
            final Future<?> result = executorService.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    CheckResults.counter++;
                }
            });

            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");

        } catch (TimeoutException e) {
            System.out.println("Not reachedin time");
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }

    }
}
