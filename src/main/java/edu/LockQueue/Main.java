package edu.LockQueue;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        LockQueue<Integer> queue = new LockQueue<>(2);
        List<Thread> listOfThread = new ArrayList<>();
        for(int i = 0 ; i < 5; i++){
            int finalI = i;
            listOfThread.add(new Thread(() -> {
                try {
                    queue.push(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Поток на запись " + finalI);
            }));
        }

        for(int i = 0 ; i < 5; i++){
            int finalI = i;
            listOfThread.add(new Thread(() -> {
                try {
                    System.out.println(queue.poll());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Поток на чтение " + finalI);
            }));
        }

        listOfThread.forEach(Thread :: start);

        for(Thread thread : listOfThread){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
