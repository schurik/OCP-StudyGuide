package chapter7.review;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ReviewAtomic {

    public static void main(String[] args) {
        final AtomicLong value1 = new AtomicLong(1);
        final long[] value2 = {0};

        IntStream.iterate(1, i->1)
                .limit(100).parallel().forEach(i -> value1.incrementAndGet());

        IntStream.iterate(1, i->1)
                .limit(100).parallel().forEach(i -> ++value2[0]);

        System.out.println(value1 + " " + value2[0]);

        //review7();
        review8();
    }

    public static void review7() {
        final List<Integer> l1 = Arrays.asList(1, 2, 3);
        final List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
        final Set<Integer>  s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);

        for (Integer i : l2) l2.add(4);
        for (Integer i : s3) s3.add(5);
        System.out.println(l1.size() + " " + l2.size() + " " + s3.size());
    }

    public static void review8() {

        Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();

        synchronized (i1){
            // TODO review .sorted()
            Integer i2 = Arrays.asList(6,7,8,9,10).parallelStream().sorted().findAny().get();
            System.out.println(i1 + " " + i2);
        }
    }
}
