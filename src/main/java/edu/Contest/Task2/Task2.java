package edu.Contest.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            //Graf graf = new Graf();
            long[] porogs = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            long sum = 0;
            for (long el : porogs) {
                sum += el;
            }
            if (n == 1) {
                System.out.println("Yes");
                continue;
            }
            int colReber = (int) sum / 2;
            boolean flag = colReber >= n - 1;
            System.out.println(flag ? "Yes" : "No");
        }}}
//            long start = System.currentTimeMillis();
//            for (int j = 0; j < n; j++) {
//                graf.add(new Node(porogs[j], j));
//            }

//            if (graf.isPorogEquals()) {
//                Node node1 = graf.graf.get(0);
//                Node node2 = graf.graf.get(1);
//                node1.porog -= 1;
//                node2.porog -= 1;
//                node1.neighbors.add(node2);
//                node2.neighbors.add(node1);
//
//                //graf.createNeighborsForEqualsInfo();
//            } //else {
//                graf.createNeighbors();
//           // }
//
//            if (graf.DepthFirstTraversal()) {
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//
//            long end = System.currentTimeMillis();
//            System.out.println(end - start);
//       }
//    }
//
//}

//class Node {
//    public int index;
//    public long porog;
//    public List<Node> neighbors = new ArrayList<>();
//
//    public Node(long porog, int index) {
//        this.porog = porog;
//        this.index = index;
//    }
//}
//
//class Graf {
//
//    public List<Node> graf = new ArrayList<>();
//
//    public void add(Node node) {
//        graf.add(node);
//    }
//
//    public boolean isPorogEquals() {
//        for (int i = 0; i < graf.size() - 1; i++) {
//            if (graf.get(i).porog != graf.get(i + 1).porog) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void createNeighborsForEqualsInfo() {
//        for (int i = 0; i < graf.size(); i++) {
//            Node node1 = graf.get(i);
//            if(node1.porog == 0) continue;
//            for (int j = 0; j < graf.size(); j++) {
//                if (i != j) {
//                    Node node2 = graf.get(j);
//                    if(node2.porog == 0) continue;
//                    if (node1.porog <= node2.porog && node1.porog != 0 ){
//                        node1.porog -= 1;
//                        node2.porog -= 1;
//                        node1.neighbors.add(node2);
//                        node2.neighbors.add(node1);
//                    }
//                }
//            }
//        }
//    }
//    public void createNeighbors() {
//        for (int i = 0; i < graf.size(); i++) {
//            Node node1 = graf.get(i);
//            if(node1.porog == 0) continue;
//            for (int j = 0; j < graf.size(); j++) {
//                if (i != j) {
//                    Node node2 = graf.get(j);
//                    if(node2.porog == 0) continue;
//                    if (node1.porog < node2.porog && node1.porog != 0) {
//                        node1.porog -= 1;
//                        node2.porog -= 1;
//                        node1.neighbors.add(node2);
//                        node2.neighbors.add(node1);
//                    }
//                }
//            }
//        }
//
//        createNeighborsForEqualsInfo();
//    }
//
//    public boolean DepthFirstTraversal()
//    {
//        List<Integer> tabu = new ArrayList<>();
//        tabu.add(graf.get(0).index);
//        DepthFirstTraversal(graf.get(0), tabu);
//        return tabu.size() == graf.size();
//    }
//
//    public void DepthFirstTraversal(Node node, List<Integer> tabu) {
//        for (Node Neighbor : node.neighbors) {
//            if (!tabu.contains(Neighbor.index)) {
//                tabu.add(Neighbor.index);
//                DepthFirstTraversal(Neighbor, tabu);
//            }
//        }
//    }
//}

