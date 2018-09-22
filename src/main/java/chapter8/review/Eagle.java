package chapter8.review;

import java.io.Serializable;

public class Eagle extends Bird implements Serializable {

    {
        this.name = "Jannete";
    }

    public Eagle() {

        this.name = "Daniel";
    }
}
