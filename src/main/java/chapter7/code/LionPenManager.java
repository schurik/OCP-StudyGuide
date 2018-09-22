package chapter7.code;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
    private void removeAnimals() {
        System.out.println("removeing animals");
    }

    private void cleanPen() {
        System.out.println("cleaning pen");
    }

    private void addAnimals() {
        System.out.println("adding animals");
    }

    public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {

        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newFixedThreadPool(4);
            final CyclicBarrier c1 = new CyclicBarrier(4);
            final CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen cleaned!"));

            final LionPenManager manager = new LionPenManager();
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTasks(c1, c2));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
