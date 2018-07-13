package chapter2.review;

public interface CanWalk {
    default void walk() {
        System.out.println("walking");
    }
}
