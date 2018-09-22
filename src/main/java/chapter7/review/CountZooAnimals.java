package chapter7.review;

import chapter2.review.TurtleFrog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CountZooAnimals {

    public static Integer performCount(int num) {
        return num*10;
    }

    public static void printResults(Future<?> f) {
        try {
            System.out.println(f.get());
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        final ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<?>> result = new ArrayList<>();

        IntStream.range(0, 10)
                .forEach(i -> result.add(service.submit(()-> performCount(i))));

        result.stream().forEach(f -> printResults(f));

        service.shutdown();
    }
}
