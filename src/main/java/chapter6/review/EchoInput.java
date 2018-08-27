package chapter6.review;

public class EchoInput {

    public static void main(String[] args) {
        if (args.length < 3) assert false;
        System.out.println(args[0]);

        int n = -1;

        assert n < 0: "OhNo";
        assert (n < 0): "OhNo";

    }

    private int addPlusOne(int a, int b) {
        //boolean assert = false;
        return 1;
    }
}
