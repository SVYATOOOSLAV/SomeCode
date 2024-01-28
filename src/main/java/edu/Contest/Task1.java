package edu.Contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

    private static boolean isStringLogo(String string){
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char el : chars){
            if(el == 'T' || el == 'I' || el == 'N' || el == 'K' || el == 'O' || el == 'F'){
                if(!map.containsKey(el)){
                    map.put(el, 1);
                }
                else{
                    map.put(el, map.get(el) + 1);
                }
            }
            else{
                return false;
            }
        }

        return map.getOrDefault('T',0) == 1 && map.getOrDefault('I', 0) == 1
                && map.getOrDefault('N', 0) == 1 && map.getOrDefault('K', 0) == 1
                && map.getOrDefault('O', 0) == 1 && map.getOrDefault('F', 0) == 2;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cntOfStr = scanner.nextInt();
        for(int i = 0; i < cntOfStr; i++){
            String str1 = scanner.next();
            String res = isStringLogo(str1) ? "Yes" : "No";
            System.out.println(res);
        }
    }
}
