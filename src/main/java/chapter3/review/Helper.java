package chapter3.review;

import java.io.FileNotFoundException;

public class Helper {
    public static <U extends Exception> void printException(U u) {
        System.out.print(u.getMessage());
    }

    public static void main(String [] args) {
        Helper.printException(new FileNotFoundException("A"));
        Helper.printException(new Exception("B"));

        // Helper.printException(new Throwable("E")); Throwable not extend Exception
    }
}
