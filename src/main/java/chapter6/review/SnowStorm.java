package chapter6.review;

public class SnowStorm {

    static class Walk implements AutoCloseable {
        @Override
        public void close() {
            throw new RuntimeException("snow");
        }
    }

    public static void main(String[] args) {
        try (Walk w1 = new Walk(); Walk w2 = new Walk()){
            throw new RuntimeException("rain");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + e.getSuppressed().length);
        }
    }
}
