package chapter2.review;

public interface CanRun {
    public default void walk() {

    }

    public abstract void run();
}
