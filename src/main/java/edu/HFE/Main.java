package edu.HFE;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(new Test(0,5, arr));
//        executorService.submit(new Test(5, 10, arr));
//        executorService.shutdown();

        RaceCondition raceCondition = new RaceCondition();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                raceCondition.add();
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                raceCondition.decrease();
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(raceCondition.getValue());


    }

    public static class RaceCondition {
        public RaceCondition(){

        }
        private int sum = 0;

        public void add() {
            sum++;
        }

        public void decrease() {
            sum--;
        }

        public int getValue() {
            return sum;
        }
    }
}

 class Test implements Runnable {
    private int left;
    private int right;
    private int[] arr;
    private int max = Integer.MIN_VALUE;

    public Test(int left, int right, int[] arr) {
        this.left = left;
        this.right = right;
        this.arr = arr;
    }

    public void run() {

        for (int i = left; i < right; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}

