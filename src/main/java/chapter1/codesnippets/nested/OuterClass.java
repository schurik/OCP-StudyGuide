package chapter1.codesnippets.nested;

public class OuterClass {

    private String outer = "";

    public void outerMethod() {

        // local inner class allowed to be abstract and defailt only
        final class LocalInnerClass {

            StaticNestedClass nested = new OuterClass.StaticNestedClass();

            void localInnerMethod() {
                System.out.print("local inner method call");
            }
        }

        // can only be instantiated inside the defining method
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.localInnerMethod();
    }

    // this a member inner class can be abstract or final
    final class MemberInnerClass {

        // static not allowed
        // static String SOME = "";

        StaticNestedClass nested = new OuterClass.StaticNestedClass();

        void innerMethod(){
            outer = "can access outer private vars";
        }
    }

    // static nested class
    private static class StaticNestedClass {
        static String SOME = "";
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();

        // check this !!
        MemberInnerClass inner = outer.new MemberInnerClass();
        inner.innerMethod();

        boolean inst = outer instanceof OuterClass;

        boolean inst2 = null instanceof OuterClass;
        // boolean inst3 = inner instanceof OuterClass; // not compiling
    }
}
