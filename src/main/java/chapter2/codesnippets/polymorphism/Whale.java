package chapter2.codesnippets.polymorphism;

public class Whale implements LivesInOcean {
    @Override
    public void makeSound() {
        System.out.println("sing");
    }
}
