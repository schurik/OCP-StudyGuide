package chapter7.review;

import java.util.concurrent.ForkJoinPool;

public class FindMin extends MyTask {

    private Integer[] elements;

    private int a;
    private int b;

    public FindMin(Integer[] elements, int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }

    @Override
    protected Integer compute() {
        if (b-a < 2) {
            return Math.min(elements[a], elements[b]);
        } else {
            int m = a + ((b-a)/2);
            System.out.println(a+","+m+","+b);
            MyTask task = new FindMin(elements, a, m);
            int result = task.fork().join();

            return Math.min(new FindMin(elements, m,b).compute(), result);
        }
    }

    public static void main(String[] args) {
        final Integer[] elem = {8, -3, 2, -54};

        MyTask task = new FindMin(elem, 0, elem.length-1);
        final ForkJoinPool pool = new ForkJoinPool(1);
        final Integer min = pool.invoke(task);

        System.out.println("Min: " + min);
    }
}
