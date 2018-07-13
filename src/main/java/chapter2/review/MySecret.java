package chapter2.review;

public class MySecret {

    public static void main(String[]args) {

        caller((e) -> "Proof");
        caller((e) -> {
            String f = "";
            return "Proof";
        });
    }

    public static void caller(Secret secret) {

    }
}
