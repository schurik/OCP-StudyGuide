package chapter7.code;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

public class WeightAnimalTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;

    public WeightAnimalTask(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {
        if (end-start <=3 ) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = Double.valueOf(new Random().nextInt(100));
                System.out.println("animal weighed: " + i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start+((end-start)/2);
            System.out.println("start: " + start + " middle: " + middle + " end: " + end);
            RecursiveTask<Double> otherTask = new WeightAnimalTask(start, middle, weights);
            otherTask.fork(); // complete the task in a separate thread

            return new WeightAnimalTask(middle, end, weights).compute() + otherTask.join(); // .join() causes the current thread to wait for the results
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<Double> task = new WeightAnimalTask(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        final Double sum = pool.invoke(task);

        System.out.println();
        System.out.print("Weights: ");
        Stream.of(weights).forEach(w -> System.out.print(w.intValue() + " "));
        System.out.println("sum: " + sum);
    }
}
