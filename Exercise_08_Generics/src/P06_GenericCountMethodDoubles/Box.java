package P06_GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> collection;

    public Box() {
        this.collection = new ArrayList<>();
    }

    public List<T> getCollection() {
        return collection;
    }

    public static <T extends Comparable> int counter(List<T> collection, T value) {
        int counter = 0;
        for (T item : collection) {
            if (item.compareTo(value) > 0) {
                counter++;
            }
        }
        return counter;
    }

}

