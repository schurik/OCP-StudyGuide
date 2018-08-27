package chapter6.review;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StuckTurkeyCage implements AutoCloseable{


    public static void main(String[] args) throws Exception { // or throws Exception


        try (StuckTurkeyCage cage = new StuckTurkeyCage()) {

        }

        try {
            throw new IOException();
        } catch (IOException | RuntimeException e ) {

        }
    }

    @Override
    public void close() throws Exception {
        throw new Exception("cage door does not close");
    }

    public void test() {
        try (StuckTurkeyCage cage = new StuckTurkeyCage()){
            System.out.println("put turkey in");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
