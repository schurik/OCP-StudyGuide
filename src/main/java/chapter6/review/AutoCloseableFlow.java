package chapter6.review;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class AutoCloseableFlow {

    static class Door implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("D");
            throw new RuntimeException();
        }
    }

    static class Window implements Closeable {
        @Override
        public void close() {
            System.out.println("W");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {

        try (Door door = new Door(); Window window = new Window()) {
            System.out.println("T");
        } catch (Exception e) {
            System.out.println("E");
        } finally {
            System.out.println("F");
        }
    }

    class Review17Closeable implements Closeable {
        @Override
        public void close()  { // throws Exception this is not allowed
            throw new IllegalStateException();
            //throw new Exception();
        }
    }
    class Review17AutoCloseable implements AutoCloseable {
        @Override
        public void close() throws IOException {
            //throw new IllegalStateException();
            throw new IOException();
        }
    }

    // 19
    public void read() throws SQLException {

        try {
            readFromDB();
        } catch (SQLException e) { // | IOException is never thrown
            throw e;
        }
    }

    public void readFromDB() throws SQLException {

    }
}
