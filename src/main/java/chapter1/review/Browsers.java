package chapter1.review;

public class Browsers {

    static class Browser {
        public void go() {
            System.out.println("in browser");
        }
    }

    static class Firefox extends Browser {
        public void go() {
            System.out.println("in firefox");
        }
    }

    static class IE extends Browser {
        @Override
        public void go() {
            System.out.println("in IE");
        }
    }

    public static void main(String [] args) {
        Browser b = new Firefox();

        IE ie = (IE) b;
        ie.go();
    }
}
