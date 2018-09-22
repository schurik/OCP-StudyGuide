package chapter7.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {

    private int sheepCount = 0;

    private final Object lock = new Object();

    // uses synchronized block
    private void incrementAndReport() {
        // synchronized (this) { // this works to
        synchronized (lock) {
            System.out.print((++sheepCount) + " ");
        }
    }

    // equivalent as the method above
    // uses synchronized method modifier
    private synchronized void incrementAndReport2() {
        System.out.print((++sheepCount) + " ");
    }

    // synchronized also works for static methods the lock is the class object
    public static void printFinishedWork() {
        synchronized (SheepManager.class) {
            System.out.println("finished work");
        }
    }

    // equivalent as the method above
    public synchronized static void printFinishedWork2() {
        System.out.println("finished work");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);

            final SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport2());
            }

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }


}
