
import java.util.*;

public class P06_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //health 250, damage 45, and armor 10
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, ArrayList<String>>> dragons = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] dragonInput = scanner.nextLine().split("\\s+");
            String type = dragonInput[0];
            String name = dragonInput[1];
            String damage = "45";
            String health = "250";
            String armor = "10";

            if (!dragonInput[2].equals("null")) damage = dragonInput[2];
            if (!dragonInput[3].equals("null")) health = dragonInput[3];
            if (!dragonInput[4].equals("null")) armor = dragonInput[4];
            String text = "damage: " + damage + ", health: " + health + ", armor: " + armor;


            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }
            if (!dragons.containsValue(name)) {
                dragons.get(type).put(name, new ArrayList<>(){{add(text);}});
            }

        }

        for (Map.Entry<String, TreeMap<String, ArrayList<String>>> entry : dragons.entrySet()) {
            TreeMap<String, ArrayList<String>> res = entry.getValue();
            int sumDamage = 0;
            int sumHealth = 0;
            int sumArmor = 0;
            int counter = 0;

            for (ArrayList<String> value : res.values()) {
                String[] damage = value.get(0).split("damage: ");
                String[] health = value.get(0).split("health: ");
                String[] armor = value.get(0).split("armor: ");

                sumDamage += Integer.parseInt(damage[1].split(",")[0]);
                sumHealth += Integer.parseInt(health[1].split(",")[0]);
                sumArmor += Integer.parseInt(armor[1]);
                counter++;
            }

            double avgDamage = (double) sumDamage / counter;
            double avgHealth = (double) sumHealth / counter;
            double avgArmor = (double) sumArmor / counter;
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n"
                    , entry.getKey(), avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, ArrayList<String>> dragonChar : res.entrySet()) {
                String toPrint = dragonChar.getValue().get(0);
                System.out.printf("-%s -> %s\n", dragonChar.getKey(), toPrint);
            }
        }
    }
}
