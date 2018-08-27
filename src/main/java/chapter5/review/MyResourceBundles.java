package chapter5.review;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyResourceBundles {

    public static void main(String[] args) {
        Locale fr = new Locale("fr");
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle rb = ResourceBundle.getBundle("chapter5.review.Dolphines", fr);
        String name = rb.getString("name");
        String age = rb.getString("age");
        System.out.println(name + age);
    }
}
