package chapter1.review;

public class Outer3 {

    class Inner3 {}

    public static void main(String[]args) {

        // Inner3 in = new Inner3();
        // Inner3 in = Outer3.new Inner3();
        // Outer3.Inner3 in = new Outer3().Inner3();
        // Outer3.Inner3 in = new Outer3().Inner3();
        Outer3.Inner3 in = new Outer3().new Inner3();
        //Outer3.Inner3 in = Outer3.new Inner3();
    }
}
