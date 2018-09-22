package chapter7.review;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReviewLocking {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();

        final ExecutorService service = Executors.newFixedThreadPool(2);
        final Future<?> f1 = service.submit(() -> {

            synchronized (o1) {
                synchronized (o2) {
                    System.out.println("T");
                }
            }
        });

        final Future<?> f2 = service.submit(() -> {

            synchronized (o2) {
                synchronized (o1) {
                    System.out.println("H");
                }
            }
        });

        f1.get();
        f2.get();

    }
}
