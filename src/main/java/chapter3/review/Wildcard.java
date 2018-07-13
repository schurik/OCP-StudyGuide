package chapter3.review;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.IOException;
import java.util.*;

public class Wildcard {
    public void showSize(List<?> list) {
        System.out.print(list.size());
    }

    public static void main(String [] args) {
        ArrayDeque<?> arrayQueue = new ArrayDeque<String>(); // implements Deque, extends AbstractCollection
        ArrayList<? extends Date> arrayList = new ArrayList<Date>();
        // List<?> list = new ArrayList<?>();
        // List<Exception> exceptionList = new ArrayList<IOException>();
        Vector<? extends Number> vector = new Vector<Integer>(); // implements List, extends AbstractList

        Wildcard w = new Wildcard();
        //w.showSize(arrayQueue);
        w.showSize(arrayList);
        w.showSize(vector);
    }
}
