package chapter4.review;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.*;

public class Streams {

    public static void main(String[] args) {
        question1(false);
        question2(false);
        question3(false);
        question6(false);
        question9(false);
        question10(false);
        question11(false);
        question16(true);
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

    private static void question10(boolean enable) {
        if (enable) {
            Stream.generate(() -> "1")
                    .filter(x -> x.length() > 1)
                    .forEach(System.out::println); // terminal operator -> void
        }
    }

    private static void question11(boolean enable) {
        if (enable) {
            // B,C,E. would be correct but
            System.out.println(Stream.iterate(1, x -> ++x)
                    .limit(5)
                    .map(x -> "" + x)
                    .collect(Collectors.joining()));
        }
    }

    private static void question12(boolean enable) {
        if (enable) {
            Supplier<String> x = String::new;
            BiConsumer<String, String> y = (a, b) -> System.out.println();
            UnaryOperator<String> z = a -> a+a;
        }
    }

    private static void question13(boolean enable) {
        if (enable) {
            final List<Integer> l1 = Arrays.asList(1, 2, 3);
//            Stream.of(l1)
//                    .map(x -> x+1)
        }
    }

    private static void question14(boolean enable) {
        if (enable) {
            final Stream<Integer> s = Stream.of(1);
            final IntStream is = s.mapToInt(x -> x);
            final DoubleStream ds = s.mapToDouble(x -> x);
//            final Stream<Integer> s2 = ds.mapToInt(x -> x);
        }
    }

    private static void question16(boolean enable) {
        if (enable) {
            final Stream<String> s = Stream.empty();
            final Stream<String> s2 = Stream.empty();

            final Map<Boolean, List<String>> p = s.collect(Collectors.partitioningBy(b -> b.startsWith("c")));
            final Map<Boolean, List<String>> g = s.collect(Collectors.groupingBy(b -> b.startsWith("c")));
            System.out.println(p + " " + g);
        }
    }

    private static void debugQuestion(final int number) {
        System.out.println(number + "----------------------");
    }

    private static void debug(final String messge) {
        System.out.println(messge);
    }
}
