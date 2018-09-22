package chapter7.review;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.DoubleStream;

public class PrintConstants {

    public static void main(String[] args) {
        final ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        DoubleStream.of(2.2,4.5)
                .forEach(c -> service.submit(
                        () -> System.out.println(c*10)
                ));

        service.execute(()-> System.out.println("Printed"));
    }
}
