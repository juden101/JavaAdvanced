package ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        T[] result = (T[]) Array.newInstance(item.getClass(), length);
        result = setValue(length, item, result);
        return result;
    }


    public static <T> T[] create(Class<T> clazz, int lenght, T item) {
        T[] result = (T[]) Array.newInstance(clazz, lenght);

        result = setValue(lenght, item, result);
        return result;
    }

    private static <T> T[] setValue(int length, T item, T[] result) {
        for (int i = 0; i < length; i++) {
            result[i] = item;
        }

        return result;
    }
}
