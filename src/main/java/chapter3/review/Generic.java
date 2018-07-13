package chapter3.review;

import java.util.TreeSet;

public class Generic<T> {

    public static void main(String[]args) {
        Generic<String> g1 = new Generic<>();
        Generic<Object> g2 = new Generic();
    }
}
