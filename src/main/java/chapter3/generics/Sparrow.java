package chapter3.generics;

import java.util.ArrayList;
import java.util.List;

public class Sparrow extends Bird {

    public static void main(String [] args) {

        List<? extends Bird> birds = new ArrayList<>();

        //birds.add(new Sparrow());
        //birds.add(new Bird());

    }
}
