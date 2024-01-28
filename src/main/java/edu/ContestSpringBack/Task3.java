package edu.ContestSpringBack;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean flag = true;

        List<Gift> info = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] data = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
            info.add(new Gift(data[0], data[1], data[2]));
        }

        info.sort(new Comparator<Gift>() {
            @Override
            public int compare(Gift o1, Gift o2) {
                return Integer.compare(o1.borderDay, o2.borderDay);
            }
        });

        List<Integer> closeDays = new ArrayList<>();

        for (Gift temp : info) {
            int timeForCreateGift = temp.deliveryDay + temp.workTime;
            if (closeDays.contains(timeForCreateGift)) {
                int newDay = timeForCreateGift;
                for (; newDay <= temp.borderDay; newDay++) {
                    if (!closeDays.contains(newDay)) {
                        closeDays.add(newDay);
                        break;
                    }
                }
                if (!closeDays.contains(newDay)) {
                    flag = false;
                    break;
                }
            } else {
                closeDays.add(timeForCreateGift);
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
class Gift{
    public int deliveryDay;
    public int workTime;
    public int borderDay;

    public Gift(int deliveryDay, int workTime, int borderDay) {
        this.deliveryDay = deliveryDay;
        this.workTime = workTime;
        this.borderDay = borderDay;
    }
}
