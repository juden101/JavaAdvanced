package P03_GenericSwapMethodStrings;

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


    public static <T> void swapper(List<T> collection, int first, int second) {
        T firstItem = collection.get(first);
        T secondItem = collection.get(second);
        collection.set(first, secondItem);
        collection.set(second, firstItem);
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        for (T item : collection) {
            toPrint.append(String.format("%s: %s\n", collection.get(0).getClass().getCanonicalName(),
                    item));
        }
        return toPrint.toString();
    }
}
