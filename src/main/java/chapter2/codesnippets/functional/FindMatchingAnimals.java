package chapter2.codesnippets.functional;

import java.util.function.Predicate;

public class FindMatchingAnimals {

    private static void print(final Animal animal, final CheckTrait trait){
        if (trait.test(animal)) {
            System.out.println(animal);
        }
    }

    private static void printWithPredicate(final Animal animal, final Predicate<Animal> trait) {
        if (trait.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[]args) {
        print(new Animal("Fish", false, true), new CheckTrait() {
            @Override
            public boolean test(Animal animal) {
                return animal.canHop();
            }
        });

        print(new Animal("Kangaroo", true, false), a -> a.canHop());
        print(new Animal("Cat", true, false), (Animal a) -> a.canHop());
        print(new Animal("Dog", true, false), (Animal a) -> { return a.canHop(); });

        printWithPredicate(new Animal("Rabbit", true, false), Animal::canHop);
    }
}
