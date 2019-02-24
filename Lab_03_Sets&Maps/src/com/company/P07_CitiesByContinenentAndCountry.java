    package com.company;

    import java.util.ArrayList;
    import java.util.LinkedHashMap;
    import java.util.Scanner;

    public class P07_CitiesByContinenentAndCountry {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());

            LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> locality = new LinkedHashMap<>();

            while (n-- > 0) {
                String[] cityInfo = scanner.nextLine().split("\\s+");
                String continent = cityInfo[0];
                String country = cityInfo[1];
                String city = cityInfo[2];

                if (!locality.containsKey(continent)) {
                    locality.put(continent, new LinkedHashMap<String, ArrayList<String>>() {{
                        put(country, new ArrayList<>() {{
                            add(city);
                        }});
                    }});
                }else {
                    if (!locality.get(continent).containsKey(country)){
                        locality.get(continent).put(country,new ArrayList<>(){{add(city);}});
                    }else {
                        locality.get(continent).get(country).add(city);
                    }
                }
            }


            for (String continent : locality.keySet()) {
                System.out.println(continent + ":");
                LinkedHashMap<String, ArrayList<String>> townsByCountry = locality.get(continent);
                for (String s : townsByCountry.keySet()) {
                    System.out.printf("%s -> %s\n",s,String.join(", " ,townsByCountry.get(s)));
                }
            }

        }
    }
