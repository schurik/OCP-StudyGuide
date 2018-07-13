package chapter2.codesnippets.polymorphism;

public class Oceanographer {

    public void checkSound(final LivesInOcean animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        Oceanographer oceanographer = new Oceanographer();

        oceanographer.checkSound(new Whale());
        oceanographer.checkSound(new Dolphin());
    }
}
