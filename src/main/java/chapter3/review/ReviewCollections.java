package chapter3.review;

import chapter3.generics.Bird;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class ReviewCollections {
    public static void main(String [] args) {

        // 4.
        System.out.println("4.\n");

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.push("hello");
        queue.push("hi");
        queue.push("ola");
        queue.pop();
        queue.peek();

        while (queue.peek() != null) {
            System.out.print(queue.pop());
        }

        // 5.
        //HashSet<Number> hashSet = new HashSet<Integer>();
        HashSet<? super ClassCastException> set = new HashSet<Exception>();
        List<String> list = new Vector<String>();
        //List<Object> list1 = new ArrayList<? extends Object>();
        Map<String, ? extends Number> map = new HashMap<String, Integer>();

        // 7.

        System.out.println("\n7.\n");
        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null);
        numbers.add(309L);

        Iterator<Number> iterator = numbers.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next());

        // 8
        System.out.println("\n8.\n");

        TreeSet<String> tree = new TreeSet<>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.print(tree.ceiling("On"));

        // 9
        System.out.println("\n9.\n");
        Map<String, Double> doubleMap = new HashMap<>();
        doubleMap.put("pi", 3.14);
        //doubleMap.put("e", 2L);

        // 11.
        System.out.println("\n11.\n");
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            intMap.put(i, i*i);
        }

        System.out.print(intMap.get(4));

        // 15.
        System.out.println("\n15.\n");

        //Comparator<Integer> c = (o1, o2) -> o2 - o1;
        List<Integer> list2  = Arrays.asList(5,4,7,1);
        Collections.sort(list2);
        System.out.println(list2 +" - "+ Collections.binarySearch(list2, 1));

        // 19.
        System.out.println("\n19.\n");
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(12);
        q.remove(1);
        System.out.print(q);

        // 20.
        System.out.println("\n20.\n");
        Map m = new HashMap();
        m.put(123, "456");
        m.put("asd", "qwe");
        //System.out.print(m.contains(123));

        // 24.
        System.out.println("\n24.\n");
        Set<String> s = new HashSet<>();
        s.add("one");
        s.add("two");
        s.add("three");
        //s.forEach(s -> System.out.print(s));
        s.forEach((str) -> System.out.print(str));
        //s.forEach(System.out.print(s));
        //s.forEach((s) -> System.out.print(s));
        s.forEach(System.out::print);

        // 25.
        System.out.println("\n25.\n");
        Map<Integer, Integer> ints = new HashMap<>();
        ints.put(1, 10);
        ints.put(2, 20);
        ints.put(3, null);

        ints.merge(1, 3, (a,b) -> a+b);
        ints.merge(3, 3, (a,b) -> a+b);
        System.out.println(ints);
    }

    // 22.
    public static <T> T doSome(T t) {
        return t;
    }
}
