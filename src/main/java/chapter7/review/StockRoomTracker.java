package chapter7.review;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class StockRoomTracker {

    public static void wait(CyclicBarrier cb) {
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {

        }
    }

    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(10, () -> System.out.println("Sock Room Full"));

        IntStream.iterate(1, i -> 1).limit(9)
                .parallel()
                .forEach(i -> wait(cb));
    }
}
