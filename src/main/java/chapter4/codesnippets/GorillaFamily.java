package chapter4.codesnippets;

public class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) { // baby effectively final since no reassignment
        String approach = "amble"; // effectively final
        //approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }
    void play(Gorilla g) {
        System.out.print(g.move());
    }
}