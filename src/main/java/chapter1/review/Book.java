package chapter1.review;

public class Book {

    private int ISBN;

    public int hashCode() {
        return ISBN;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Book)) {
            return false;
        }

        Book b = (Book) obj;
        return this.ISBN == b.ISBN;
    }


}
