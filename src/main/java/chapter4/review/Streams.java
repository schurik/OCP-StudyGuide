package chapter4.review;

import java.util.OptionalLong;
import java.util.function.Predicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        // 1
        question1(false);

        // 2
        question2(false);

        // 3
        question3(false);
        question6(false);
        question9(true);
    }

    private static void question1(boolean enable) {
        if (enable) {
            debugQuestion(1);
            Stream<String> stream = Stream.iterate("", s -> s + 1);
            System.out.println(stream.limit(2).map(x -> x + 2));
        }
    }

    private static void question2(boolean enable) {
        if (enable) {
            debugQuestion(2);
            Predicate<? super String> predicate = s -> s.startsWith("g");
            Stream<String> stream1 = Stream.generate(() -> "growl!");
            Stream<String> stream2 = Stream.generate(() -> "growl!");
            boolean any = stream1.peek(v -> debug(v)).anyMatch(predicate);
            boolean all = stream2.peek(v -> debug(v)).allMatch(predicate);
            debug(any + " " + all);
        }
    }

    private static void question3(boolean enable) {
        if (enable) {
            debugQuestion(3);
            Predicate<? super String> predicate = s -> s.length() > 3;
            Stream<String> stream = Stream.iterate("-", s -> s + s);
            boolean noneMatch = stream.noneMatch(predicate);
            boolean anyMatch = stream.anyMatch(predicate);
            debug(noneMatch + " " + anyMatch);
        }
    }
    private static void question6(boolean enable) {
        if (enable) {
            Stream<String> stream = Stream.generate(() -> "meow!");
            //boolean b = stream.allMatch(String::isEmpty);
            //boolean b = stream.anyMatch(String::isEmpty);
            boolean b = stream.noneMatch(String::isEmpty);
            debug("6: " + b);
        }
    }
    private static void question9(boolean enable) {
        if (enable) {
            LongStream longStream = LongStream.of(1, 2, 3);
            OptionalLong optionalLong = longStream.map(n -> n * 10)
                    .filter(n -> n < 5)
                    .findFirst();
            if (optionalLong.isPresent()) debug(""+optionalLong.getAsLong());
            optionalLong.ifPresent(System.out::println);
        }
    }

    private static void question91(boolean enable) {
        if (enable) {

        }
    }

    private static void debugQuestion(final int number) {
        System.out.println(number + "----------------------");
    }

    private static void debug(final String messge) {
        System.out.println(messge);
    }
}
