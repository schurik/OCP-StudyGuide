package chapter8.review;

import java.io.*;

public class ObjectSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File data = new File("zebra.data");

        createFile(new Zebra(), data);

        final Serializable zebra = getZebra(data);
        System.out.println(zebra);


        File data2 = new File("eagle.data");

        createFile(new Eagle(), data2);

        final Serializable eagle = getZebra(data2);
        System.out.println(eagle);

    }

    private static Serializable getZebra(File file) throws IOException, ClassNotFoundException {

        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){

            return (Serializable) in.readObject();
        }
    }

    private static void createFile(Serializable zebra, File dataFile) throws IOException {

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){

            out.writeObject(zebra);
        }
    }
}
