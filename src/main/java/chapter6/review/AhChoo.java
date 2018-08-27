package chapter6.review;

public class AhChoo {


    static class SneezeException extends Exception {

    }

    static class SniffleException extends SneezeException {

    }

    public static void main(String[] args) throws SneezeException {
        try {
            throw new SneezeException();
        } catch (SneezeException | RuntimeException e) {
        //} catch (SneezeException | SniffleException e) {
            //e = new Exception(); // incompatible Type

            // e = new RuntimeException();
            // e = new SneezeException();
            // e = new SniffleException(); // can not assign to final variable e in a multi-catch e is effectively final
            throw  e;
        }
    }
}
