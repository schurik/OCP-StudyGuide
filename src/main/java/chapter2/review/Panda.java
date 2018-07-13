package chapter2.review;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.function.Predicate;

public class Panda {
    int age;

    public static void main(String[]args){
        Panda p1 = new Panda();
        p1.age = 1;

        check(p1, p -> p.age < 5);
    }

    public static void check(Panda p, Predicate<Panda> pred) {
        String result = pred.test(p) ? "match" : "not match";
        System.out.println(result);
    }
}