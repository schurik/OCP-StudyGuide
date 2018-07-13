package chapter2.review;

public class Frog implements CanHop {

    public static void main(String []args) {
        CanHop frog = new TurtleFrog();
        Frog frog2 = new TurtleFrog();
        Object frog3 = new TurtleFrog();
        TurtleFrog frog4 = new TurtleFrog();

        //BrazilianHornetFrog frog5 = new TurtleFrog();
    }
}
