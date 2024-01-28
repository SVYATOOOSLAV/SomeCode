package edu.Contest.Task4;

import java.util.*;
import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = parameters[0];
        int k = parameters[1];

        Set<String> companyNeeded = new HashSet<>();
        for (int i = 0; i < k; i++) {
            companyNeeded.add(scanner.nextLine());
        }

        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.add(scanner.nextLine().split(" "));
        }
        tree.createTree();
        tree.createSubtrees();

        System.out.println(tree.getMinimumCost(companyNeeded));
    }
}

class Node {
    public int parentPosition;
    public int cost;
    public String company;
    public List<Node> children = new ArrayList<>();

    public Node(int parentPosition, int cost, String company) {
        this.parentPosition = parentPosition;
        this.cost = cost;
        this.company = company;
    }
}

class Tree {
    List<Node> subtrees = new ArrayList<>(); // ноды как корни поддеревьев
    List<Node> listVersh = new ArrayList<>();
    List<Integer> allSumFromSubtrees = new ArrayList<>();
    Node root;

    public void add(Object[] info) {
        Node versh = new Node(
                Integer.parseInt(info[0].toString()),
                Integer.parseInt(info[1].toString()),
                info[2].toString());
        if (versh.parentPosition == 0) {
            root = versh;
        }
        listVersh.add(versh);
    }

    public void createTree() {
        for (Node currentVersh : listVersh) {
            int indexParent = currentVersh.parentPosition - 1;
            if (indexParent != -1) {
                listVersh.get(indexParent).children.add(currentVersh);
            }
        }
    }

    public void createSubtrees() {
        subtrees.add(root);
        createSubtrees(root);
    }
    private void createSubtrees(Node treeNode) {
        for (Node node : treeNode.children) {
            if(!node.children.isEmpty()){
                subtrees.add(node);
                createSubtrees(node);
            }
        }
    }

    public int getMinimumCost(Set<String> neededCompanies){
        for(Node rootSubtree : subtrees){
            cost = rootSubtree.cost;
            Set<String> companiesInSubtree = new HashSet<>();
            companiesInSubtree.add(rootSubtree.company);

            costFromSubtree(rootSubtree, companiesInSubtree );
            if(neededCompanies.equals(companiesInSubtree)){
                allSumFromSubtrees.add(cost);
            }
        }

        List<Integer> sortedList =  allSumFromSubtrees.stream().sorted().toList();
        return sortedList.isEmpty() ? -1 : sortedList.get(0);
    }

    int cost;
    private void costFromSubtree(Node treeNode, Set<String> companiesInSubtree){
        for(Node node : treeNode.children){
            cost += node.cost;
            companiesInSubtree.add(node.company);
            costFromSubtree(node, companiesInSubtree);
        }
    }
}
