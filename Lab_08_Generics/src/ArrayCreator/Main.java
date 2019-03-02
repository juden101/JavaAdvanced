package ArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = ArrayCreator.create(3, 10);
        String[] strings = ArrayCreator.create(String.class, 10, "empty");

        for (String string : strings) {
            System.out.println(string);
        }

        for (Integer integer : numbers) {
            System.out.println(integer);
        }
    }
}
