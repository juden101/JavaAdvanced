package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> integerScale = new Scale<>(20, 20);

        System.out.println(integerScale.getHeavier());

        Scale<String> stringScale = new Scale<>("abd", "abc");

        System.out.println(stringScale.getHeavier());

        Scale<Character> characterScale = new Scale<>('a', 'b');

        System.out.println(characterScale.getHeavier());
    }
}
