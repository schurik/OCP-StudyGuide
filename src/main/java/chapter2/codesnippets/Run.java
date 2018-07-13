package chapter2.codesnippets;

public interface Run extends Walk {

    default double speed() {
        return 3.0;
    }

    @Override
    default boolean canHunt() {
        return false;
    }
}
