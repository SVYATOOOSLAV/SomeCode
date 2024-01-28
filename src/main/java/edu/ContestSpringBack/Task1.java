package edu.ContestSpringBack;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        solve(input);
    }

    public static void solve(String input) {
        String inputWithStar = input.replace("code", "*");
        char[] chars = inputWithStar.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                StringBuilder digits = new StringBuilder();
                for (int j = i + 1; j < chars.length; j++) {
                    if (!String.valueOf(chars[j]).matches("^\\d$")) { // если не число
                        if (digits.isEmpty()) { //проверка условия code(letter)
                            result.append("code").append(chars[j]);
                            i++;
                        }
                        break;
                    }
                    digits.append(chars[j]);
                    i++;
                }
                if (!digits.isEmpty()) {
                    result.append("???");
                }
            } else {
                result.append(chars[i]);
            }
        }
        System.out.println(result);
    }
}
