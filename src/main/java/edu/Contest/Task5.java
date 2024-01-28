package edu.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = parameters[0];
        int m = parameters[1];
        int q = parameters[2];

        long[] manuls = Arrays.stream(scanner.nextLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        Graf graf = new Graf();
        for (int i = 0; i < n; i++) {
            graf.add(new Node(i, manuls[i]));
        }

        for (int i = 0; i < m; i++) {
            int[] v = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            graf.createNeighbors(v[0] - 1, v[1] - 1);
        }

        for (int i = 0; i < q; i++) {
            String[] event = scanner.nextLine().split(" ");
            switch (event[0]) {
                case "?":
                    graf.printManuls(Integer.parseInt(event[1]) - 1);
                    break;
                case "+":
                    graf.plusManuls(Integer.parseInt(event[1]) - 1, Integer.parseInt(event[2]));
                    break;
            }
        }
    }
}

class Node {
    public long cntManul;
    public List<Node> neighbors = new ArrayList<>();

    public Node(int index, long cntManul) {
        this.cntManul = cntManul;
    }
}

class Graf {

    public List<Node> graf = new ArrayList<>();

    public void add(Node node) {
        graf.add(node);
    }

    public void createNeighbors(int i, int j) {
        graf.get(i).neighbors.add(graf.get(j));
        graf.get(j).neighbors.add(graf.get(i));
    }

    public void plusManuls(int indexVersh, int cntManuls) {
        for (Node neighbor : graf.get(indexVersh).neighbors) {
            neighbor.cntManul += cntManuls;
        }
    }

    public void printManuls(int indexVersh) {
        System.out.println(graf.get(indexVersh).cntManul);
    }

}