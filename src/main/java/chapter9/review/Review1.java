package chapter9.review;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;

public class Review1 {

    public static void main(String[] args) {

        /*
        final Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
        final Path relativize = path.normalize().relativize(Paths.get("/lion"));
        System.out.println(relativize);


        try {
            Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {


        }


        final Path path1 = Paths.get("/zoo/animals/bear/koala/food.txt");
        System.out.println(path1.subpath(1,3).getName(1).toAbsolutePath());

        if (Files.isDirectory(path) && Files.isSymbolicLink(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.copy(Paths.get(""), Paths.get(""), StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Path path2 = FileSystems.getDefault().getPath("");

        try {
            Paths.get(new URI(""));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        new File("dsf").toPath();

        try {
            Files.find(path, 0, (p, a)-> a.isSymbolicLink()).map(p -> p.toString())
                    .collect(Collectors.toList())
                    .stream()
                    .map(s -> s.toString().endsWith(".txt"))
                    .forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.walk(Paths.get("..").toRealPath().getParent())
            .map(p -> p.toAbsolutePath().toString())
            .filter(s->s.endsWith(".java"))
            .collect(Collectors.toList())
            .forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        final Path normalize = Paths.get(".").normalize();
        int count = 0;
        for (int i = 0; i < normalize.getNameCount(); i++) {
            count++;
            System.out.println("asd"+normalize.getName(0)+"uuuu");;
        }
        System.out.println("dfghjk: " + count);

    }
}
