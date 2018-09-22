package chapter7.code;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Stream;

public class WeightAnimalAction extends RecursiveAction {

    private int start;
    private int end;
    private Double[] weights;

    public WeightAnimalAction(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {
        if (end-start <=3 ) {
            for (int i = start; i < end; i++) {
                weights[i] = Double.valueOf(new Random().nextInt(100));
                System.out.println("animal weighed: " + i);
            }
        } else {
            int middle = start+((end-start)/2);
            System.out.println("start: " + start + " middle: " + middle + " end: " + end);
            invokeAll(new WeightAnimalAction(start, middle, weights), new WeightAnimalAction(middle, end, weights));
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<?> task = new WeightAnimalAction(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        System.out.println();
        System.out.print("Weights: ");
        Stream.of(weights).forEach(w -> System.out.print(w.intValue() + " "));
    }
}
