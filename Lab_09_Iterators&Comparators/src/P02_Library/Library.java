package P02_Library;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book books[];

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<Book> {
        private int counter;

        LibIterator(int counter) {
            this.counter = 0;
        }

        public LibIterator() {
        }

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }

    ;
}

