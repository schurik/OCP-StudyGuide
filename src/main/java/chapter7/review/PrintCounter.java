package chapter7.review;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class PrintCounter {

    static int counter = 0;

    public static void main(String[] args) {
        final ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<?>> result = new ArrayList<>();

        //IntStream.iterate(0, i -> i+1).limit(5).forEach(i -> result.add(service.execute(() -> 5)));

        service.shutdown();


        final Console console = System.console();

        console.writer().append("");
        console.printf("");
    }
}
