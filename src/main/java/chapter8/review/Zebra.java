package chapter8.review;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Zebra implements Serializable {

    private static final long serialUID = 1;

    private transient String name = "George";
    private static String birthPlace = "afrika";
    private transient Integer age;
    private List<Zebra> friends = new ArrayList<>();

    private Object tail = null;

    {
        age = 10;
    }

    public Zebra() {
        this.name = "Sophia";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getBirthPlace() {
        return birthPlace;
    }

    public static void setBirthPlace(String birthPlace) {
        Zebra.birthPlace = birthPlace;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Zebra> getFriends() {
        return friends;
    }

    public void setFriends(List<Zebra> friends) {
        this.friends = friends;
    }

    public Object getTail() {
        return tail;
    }

    public void setTail(Object tail) {
        this.tail = tail;
    }
}
