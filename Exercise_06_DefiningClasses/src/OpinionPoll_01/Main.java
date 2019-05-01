package OpinionPoll_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person p = new Person(name, age);
            people.add(p);
        }

        people.stream().sorted(Comparator.comparing(Person::getName))
                .filter(p -> p.getAge() > 30)
                .forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));

    }
}
