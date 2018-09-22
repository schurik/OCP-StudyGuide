package chapter8.review;

import java.io.*;

public class IOStreams {

    public static void main(String[] args) throws IOException {

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("sdf")))){
            out.write(4);
        }
    }
}
