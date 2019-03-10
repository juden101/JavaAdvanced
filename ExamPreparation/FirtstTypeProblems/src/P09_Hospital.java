import java.util.*;

public class P09_Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> departaments = new LinkedHashMap<>();
        HashMap<String, TreeSet<String>> patientByDoctor = new HashMap<>();
        HashMap<String, LinkedHashMap<Integer, List<String>>> room = new HashMap<>();

        String data = scanner.nextLine();

        while (!data.equals("Output")) {
            String[] info = data.split("\\s+");
            String departament = info[0];
            String doc = info[1] + " " + info[2];
            String patient = info[3];

            if (!departaments.containsKey(departament)) {
                departaments.put(departament, new ArrayList<>());
                room.put(departament, new LinkedHashMap<>());
            }
            departaments.get(departament).add(patient);

            if (!patientByDoctor.containsKey(doc)) {
                patientByDoctor.put(doc, new TreeSet<>());
            }
            patientByDoctor.get(doc).add(patient);

            int n = departaments.get(departament).size() - 1;
            int roomNumber = (n / 3) + 1;
            if (!room.get(departament).containsKey(roomNumber)) {
                room.get(departament).put(roomNumber, new ArrayList<>());
            }
            room.get(departament).get(roomNumber).add(patient);

            data = scanner.nextLine();
        }

        String line = scanner.nextLine().trim();

        while (!line.contains("End")) {

            if (departaments.containsKey(line) && line.split("\\s+").length == 1) {
                departaments.get(line)
                        .forEach(System.out::println);
            } else if (patientByDoctor.containsKey(line)) {
                patientByDoctor.get(line)
                        .forEach(System.out::println);
            } else {
                int num = Integer.parseInt(line.split("\\s+")[1]);

                for (int i = num; i < num + 1; i++) {
                    room.get(line.split("\\s+")[0]).get(num).stream().sorted(Comparator.naturalOrder())
                            .forEach(System.out::println);
                }
            }
            line = scanner.nextLine().trim();
        }
    }
}

