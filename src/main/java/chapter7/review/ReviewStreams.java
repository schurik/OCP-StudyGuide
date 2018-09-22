package chapter7.review;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReviewStreams {

    public static void main(String[] args) throws InterruptedException {
        final List<Integer> c = Arrays.asList(1,2);
        c.parallelStream().parallel();

        c.stream().parallel();

        System.out.println(Arrays.asList("sadf", "asdf", "asdf", "asdf")
                .parallelStream()
                .parallel()
                .reduce(0,
                        (s1,s2) -> s1 + s2.length(),
                        (l1, l2)-> l1+l2));


        final Stream<String> cats = Stream.of("leo", "lynx", "ole", "puma").parallel();
        final Stream<String> bears = Stream.of("panda", "grizzly", "polar").parallel();

        final ConcurrentMap<Boolean, List<String>> data = Stream.of(cats, bears).flatMap(s -> s)
                .collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
        System.out.println(data.get(false).size() + " " + data.get(true).size());

        addItems(new LinkedBlockingDeque<>());
    }

    public static void addItems(final BlockingDeque<Integer> deque) throws InterruptedException {
        deque.offer(103);
        deque.offerFirst(20, 1, TimeUnit.SECONDS);
        deque.offerLast(85, 1, TimeUnit.HOURS);

        System.out.println(deque.pollFirst(200, TimeUnit.NANOSECONDS));
        System.out.println(deque.pollLast(1, TimeUnit.MINUTES));
    }
}
