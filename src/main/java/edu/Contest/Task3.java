package edu.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private static volatile int saveMoney = 0;
    private static Thread getThreadForTask(int[] giftPrice, int n, int start, int end) {
        return new Thread(() -> {
            for (int money = start; money <= end; money++) {
                int tempMoney = money;
                for (int giftIndex = 0; giftIndex < n; giftIndex++) {
                    if (tempMoney - giftPrice[giftIndex] >= 0) {
                        tempMoney -= giftPrice[giftIndex];
                    }
                }
                if (tempMoney > saveMoney) {
                    saveMoney = tempMoney;
                }
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] giftPrice = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = parameters[0];
        int m = parameters[1];

        List<Thread> listOfThread = new ArrayList<>();

        listOfThread.add(getThreadForTask(giftPrice, n, 0, m/2 ));
        listOfThread.add(getThreadForTask(giftPrice, n, m / 2 + 1, m ));
        for(Thread thread : listOfThread){
            thread.start();
        }
        for(Thread thread : listOfThread){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(saveMoney);
        System.out.println();
    }
}
