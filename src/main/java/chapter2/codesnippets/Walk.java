package chapter2.codesnippets;

public interface Walk {

    default double speed() {
        return 2.0;
    }

    boolean canHunt();
}
