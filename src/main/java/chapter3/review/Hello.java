package chapter3.review;

public class Hello<T> {

    T t;
    Hello(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();
    }

    public static void main(String [] args) {
        System.out.print(new Hello<String>("hi"));
        System.out.print(new Hello("there"));
    }
}
