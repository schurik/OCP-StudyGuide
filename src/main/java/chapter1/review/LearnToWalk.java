package chapter1.review;

public class LearnToWalk {

    String walk = "walk,";

    public void toddle() throws Exception {}

    static class BabyRhino extends LearnToWalk{

        String walk = "rhino walk,";

        @Override
        public final void toddle() {
        }
    }

    public static void main(String[]args) {
        LearnToWalk a = new BabyRhino();
        System.out.println(a.walk);

        BabyRhino b = new BabyRhino();
        System.out.println(b.walk);
    }
}
