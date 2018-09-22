package chapter7.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {

    private static int sheepCount2 = 0;
    private static AtomicInteger sheepCount1 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            for (int i = 0; i < 100; i++) {
                service.execute(() -> {
                    sheepCount1.getAndIncrement();
                    sheepCount2++;
                });
            }

            Thread.sleep(1000);
            System.out.println(sheepCount1 +" "+sheepCount2);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }


}
