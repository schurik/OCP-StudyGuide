package chapter7.code;

import java.util.concurrent.*;

public class AddData {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();

            // using Callable
            final Future<Integer> result = executorService.submit(() -> 1+2);
            System.out.println(result.get());

        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
