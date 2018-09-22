package chapter7.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ScheduledExecutor {

    AtomicLong l = new AtomicLong(1);

    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadScheduledExecutor();

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
