package chapter8.review;

import java.io.Serializable;

public class Bird implements Serializable {

    protected transient String name = "Bridget";

    public Bird() {
        this.name = "Matt";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
