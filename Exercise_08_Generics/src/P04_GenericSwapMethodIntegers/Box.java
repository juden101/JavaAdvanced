package P04_GenericSwapMethodIntegers;

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
        T firstNumber = collection.get(first);
        T secondNumber = collection.get(second);
        collection.set(first, secondNumber);
        collection.set(second, firstNumber);
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
