package edu.ContestSpringBack.Task5;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Map<Integer, List<Integer>>> sub = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            sub.add(new HashMap<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int[] data = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            graph.get(data[0] - 1).add(data[1] - 1);
            graph.get(data[1] - 1).add(data[0] - 1);
            sub.get(data[0] - 1).put(data[1] - 1, new ArrayList<>());
            sub.get(data[1] - 1).put(data[0] - 1, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for(Integer el : graph.get(i)){
                tabu.clear();
                tabu.add(i);
                visitedVersh.clear();
                depthFirstTraversal(el);
                List<Integer> temp = new ArrayList<>(visitedVersh);
                sub.get(i).put(el, temp);
            }
        }

        int q = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < q; i++){
            int[] data = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(var el : sub.get(data[0] - 1).entrySet()){
                if(el.getValue().contains(data[1] - 1)){
                    System.out.println(el.getKey() + 1);
                    break;
                }
            }
        }
    }

    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> tabu = new ArrayList<>();
    static List<Integer> visitedVersh = new ArrayList<>();

    public static void depthFirstTraversal(int indexMain) {
        tabu.add(indexMain);
        visitedVersh.add(indexMain);
        for (Integer el : graph.get(indexMain)) {
            if (!tabu.contains(el)) {
                depthFirstTraversal(el);
            }
        }
    }
}

