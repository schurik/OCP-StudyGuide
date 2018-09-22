package chapter7.review;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CountNumbers extends RecursiveAction {

    private int start;
    private int end;

    public CountNumbers(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        if (start<0) return;
        else {
            int middle = start + ((end-start)/2);
            invokeAll(new CountNumbers(start, middle), new CountNumbers(middle,end));
        }
    }

    public static void main(String[] args) {
        ForkJoinTask<?> task = new CountNumbers(0,4);
        final ForkJoinPool pool = new ForkJoinPool();

        final Object result = pool.invoke(task);
    }
}
