package chapter1.codesnippets;

public abstract interface DefaultMethodInterface {

    default void foo() {

    }
}

class A implements DefaultMethodInterface {
    // not needed to implement foo()
}