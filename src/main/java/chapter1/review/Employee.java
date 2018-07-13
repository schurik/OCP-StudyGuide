package chapter1.review;

public class Employee {

    public int id;
    public String firstName, lastname;
    public int year;

    @Override
    public int hashCode() {
        return id;
    }

    public boolean equals(Employee emp) {
        return this.id == emp.id;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 101;

        Employee e2 = new Employee();
        e2.id = 101;

        if (e1.equals(e2)) {
            System.out.println("success");
        } else {
            System.out.println("Failure");
        }


        String s1 = "canada";
        String s2 = new String(s1);

        if (s1 == s2) {
            System.out.println("s1 == s2");
        }

        if (s1.equals(s2)) {
            System.out.println("s1.equals(s2)");
        }
    }
}
