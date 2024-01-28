package edu.ContestSpringBack;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] heightBooks = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(height -> Integer.parseInt(height))
                .toArray();

        int numberOfStacks = 0;

        Map<Integer, Integer> info = new HashMap<>(); // вес книги, колво
        for (int i = 0; i < n; i++) {
            if (!info.containsKey(heightBooks[i])) {
                info.put(heightBooks[i], 1);
                numberOfStacks++;
            } else {
                info.put(heightBooks[i], info.get(heightBooks[i]) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(var entry : info.entrySet()){
            result.add(entry.getValue());
        }
        Collections.sort(result);

        System.out.println(numberOfStacks);
        int i = 0;
        for (; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.print(result.get(i));
    }
}

