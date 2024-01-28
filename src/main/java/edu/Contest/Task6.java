package edu.Contest;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = parameters[0];
        int q = parameters[1];
        t = new int[8 * n];
        int[] a = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        buildTreeLineSegment(a, 1, 0, n - 1);
//        System.out.println(Arrays.toString(t));
//        System.out.println(maxOnLineSegment(1,0,n-1,2,3));
//        plus(1,0,n,1,5,1);
//        System.out.println(Arrays.toString(t));
//        System.out.println(maxOnLineSegment(1,0,n-1,2,3));

        for(int i = 0; i < q; i++){
            String[] event = scanner.nextLine().split(" ");
            switch (event[0]){
                case "?":
                    System.out.println(maxOnLineSegment(1, 0, n, Integer.parseInt(event[1])-1,
                            Integer.parseInt(event[2])-1));
                    break;
                case "+" : plus(1,0,n,Integer.parseInt(event[1])-1,
                        Integer.parseInt(event[2])-1,Integer.parseInt(event[3])-1);
                break;
            }
        }
    }

    static int[] t;

    static void buildTreeLineSegment(int[] a, int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            buildTreeLineSegment(a, v * 2, tl, tm);
            buildTreeLineSegment(a, v * 2 + 1, tm + 1, tr);
            t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
        }
    }

    static int maxOnLineSegment(int v, int tl, int tr, int l, int r) {
        if (l <= tl && tr <= r){
            return t[v];
        }
        if (tl == tr){
            return 0;
        }
        int tm = (tl + tr) / 2;
        return Math.max(maxOnLineSegment(v * 2, tl, tm, l, r),
                maxOnLineSegment(v * 2 + 1, tm + 1, tr, l, r));
    }

    static void plus(int v, int tl, int tr, int l, int r, int add) {
        if (l <= tl && tr <= r){
            t[v] += add;
            if (t[2*v] == 0 && t[2*v + 1] == 0) return;
        }

        if (tl == tr){
            return;
        }

        else {
            int tm = (tl + tr) / 2;
            plus(v * 2, tl, tm, l, r, add);
            plus(v * 2 + 1, tm + 1, tr, l, r, add);
            t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
        }
    }
}
