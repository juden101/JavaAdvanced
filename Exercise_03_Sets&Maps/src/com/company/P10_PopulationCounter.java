package com.company;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> populationByCountryAndCity = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("report")) {
            String[] tokens = line.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt(tokens[2]);

            if (!populationByCountryAndCity.containsKey(country)) {
                populationByCountryAndCity.put(country, new LinkedHashMap<>() {{
                    put(city, population);
                }});
            } else {
                if (!populationByCountryAndCity.get(country).containsKey(city)) {
                    populationByCountryAndCity.get(country).put(city, population);
                } else {
                    populationByCountryAndCity.get(country).put(city, populationByCountryAndCity.get(country).get(city) + population);
                }

            }

            line = scanner.nextLine();
        }


        populationByCountryAndCity.entrySet().stream()
                .sorted((country1, country2) -> //Sorting the countries by Population, than by Order
                        country2.getValue().values().stream().reduce(0L, Long::sum)
                                .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)\n", country.getKey(),
                            country.getValue().values().stream().reduce(0L, Long::sum));
                    country.getValue().entrySet().stream()
                            .sorted((city1, city2) -> //Sorting the cities by Population, than by Order
                                    city2.getValue().compareTo(city1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d\n", city.getKey(), city.getValue()));

                });
    }
}
