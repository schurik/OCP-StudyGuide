package chapter1.codesnippets;

public enum Season {

    SUMMER(4) {
        @Override
        void print() {

        }
    }, WINTER(2) {
        @Override
        void print() {

        }

        @Override
        public void printHours() {
            super.printHours();
        }
    };

    private int hours;

    private Season(final int hours) {
        this.hours = hours;
    }

    public void printHours() {
        System.out.println(hours);
    }

    abstract void print();
}
