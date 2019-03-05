package P03_ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        if (authors.length != 0) {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        } else {
            this.authors = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s\n"
                , this.title
                , this.year
                , this.authors);
    }

    @Override
    public int compareTo(Book o) {
        int bookTitleResult = this.title.compareTo(o.title);
        if (bookTitleResult == 0) {
            return Integer.compare(this.year, o.year);
        } else {
            return bookTitleResult;
        }
    }
}
