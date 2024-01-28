package edu.ContestSpringBack;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dataMain = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        final int n = dataMain[0], m = dataMain[1], g = dataMain[2];
        int[] dataInterestingness = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] dataVoracity = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Graph graph = new Graph();
        long start = System.currentTimeMillis();
        //create friends
        for (int i = 0; i < n; i++) {
            graph.add(new Node(dataInterestingness[i], dataVoracity[i]));
        }

        //create connection
        for (int i = 0; i < m; i++) {
            int[] friends = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            graph.createNeighbors(friends[0] - 1, friends[1] - 1);
        }

        graph.startDepthFirstTraversal();

        List<ConnectionInfo> connectionInfo = graph.getAllInfo();

        Comparator<ConnectionInfo> compVoracity = new Comparator<ConnectionInfo>() {
            @Override
            public int compare(ConnectionInfo o1, ConnectionInfo o2) {
                return Integer.compare(o1.getSumVoracity(), o2.getSumVoracity());
            }
        };

        Comparator<ConnectionInfo> compInter = new Comparator<ConnectionInfo>() {
            @Override
            public int compare(ConnectionInfo o1, ConnectionInfo o2) {
                return Integer.compare(o2.getSumInterestingness(), o1.getSumInterestingness());
            }
        };

        connectionInfo.sort(compInter);
        int result1 = getResult(connectionInfo, g);

        connectionInfo.sort(compVoracity);
        int result2 = getResult(connectionInfo, g);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Math.max(result1, result2));
    }

    private static int getResult(List<ConnectionInfo> connectionInfo, int g) {
        int result = 0;
        for(int i = 0; i < connectionInfo.size(); i++){
            if(connectionInfo.get(i).getSumVoracity() > g){
                continue;
            }
            int sumInteres = connectionInfo.get(i).getSumInterestingness(),
                    sumVorac = connectionInfo.get(i).getSumVoracity();
            for(int j = i + 1; j < connectionInfo.size(); j++){
                if(sumVorac + connectionInfo.get(j).getSumVoracity() <= g){
                    sumVorac +=  connectionInfo.get(j).getSumVoracity();
                    sumInteres += connectionInfo.get(j).getSumInterestingness();
                }
            }
            if(result < sumInteres){
                result = sumInteres;
            }
        }
        return result;
    }
}

class ConnectionInfo {
    private int sumInterestingness;
    private int sumVoracity;

    public int getSumInterestingness() {
        return sumInterestingness;
    }

    public int getSumVoracity() {
        return sumVoracity;
    }

    public void addInterestingness(int value) {
        sumInterestingness += value;
    }

    public void addVoracity(int value) {
        sumVoracity += value;
    }
}

class Node {
    public int interestingness;
    public int voracity;
    public List<Node> neighbors = new ArrayList<>();

    public Node(int interestingness, int voracity) {
        this.interestingness = interestingness;
        this.voracity = voracity;
    }
}

class Graph {

    private List<Node> graph = new ArrayList<>();
    private List<ConnectionInfo> allInfo = new ArrayList<>();

    public void add(Node node) {
        graph.add(node);
    }

    public List<ConnectionInfo> getAllInfo() {
        return allInfo;
    }

    public void createNeighbors(int i, int j) {
        graph.get(i).neighbors.add(graph.get(j));
        graph.get(j).neighbors.add(graph.get(i));
    }

    public void startDepthFirstTraversal() {
        List<Node> tabu = new ArrayList<>();
        for (Node node : graph) {
            if (!tabu.contains(node)) {
                ConnectionInfo info = new ConnectionInfo();
                tabu.add(node);
                info.addInterestingness(node.interestingness);
                info.addVoracity(node.voracity);

                depthFirstTraversal(node, tabu, info);
                allInfo.add(info);
            }
        }
    }

    private void depthFirstTraversal(Node node, List<Node> tabu, ConnectionInfo info) {
        for (Node friend : node.neighbors) {
            if (!tabu.contains(friend)) {
                tabu.add(friend);
                info.addInterestingness(friend.interestingness);
                info.addVoracity(friend.voracity);
                depthFirstTraversal(friend, tabu, info);
            }
        }
    }
}