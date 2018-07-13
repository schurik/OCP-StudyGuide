package chapter2.review;

public class Climber {

    public static void main(String[]args) {
        //check((h, l) -> h.toString(), 5); h is Climb and it has no toString() method
    }

    private static void check(Climb climb, int heigt) {
        if (climb.isToHigh(heigt, 10)) {
            System.out.println("to high");
        } else {
            System.out.println("ok");
        }
    }
}
