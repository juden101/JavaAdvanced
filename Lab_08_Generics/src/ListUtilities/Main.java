package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 2, 3, 4, 5);
        Integer maxInteger = ListUtils.getMax(integers);
        Integer minInteger = ListUtils.getMin(integers);
        System.out.println("Max Integer -> " + maxInteger);
        System.out.println("Min Integer -> " + minInteger);
    }
}
