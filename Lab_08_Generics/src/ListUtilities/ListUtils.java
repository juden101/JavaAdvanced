package ListUtilities;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable> T getMax(List<T> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T maxElement = collection.get(0);
        for (int i = 0; i < collection.size(); i++) {
            if (maxElement.compareTo(collection.get(i)) < 0) {
                maxElement = collection.get(i);
            }
        }
        return maxElement;
    }

    public static <T extends Comparable> T getMin(List<T> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T minElement = collection.get(0);
        for (int i = 0; i < collection.size(); i++) {
            if (minElement.compareTo(collection.get(i)) > 0) {
                minElement = collection.get(i);
            }
        }
        return minElement;
    }
}
