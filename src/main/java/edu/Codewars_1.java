package edu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Codewars_1 {
    public static void main(String[] args) {
//        int sum = IntStream
//                .range(1,11)
//                .filter(el -> el % 3 == 0 || el % 5 == 0)
//                .sum();

        String[] arr = new String[] {"Pig latin is cool", "Hello world !"};
        String test = "Pig latin is cool", test2 = "Hello world !";

       Arrays.stream(test2.split(" "))
                 .map(word -> {
                     if (word.matches(".*[a-zA-Z].*")) {
                         char firstLetter = word.charAt(0);
                         return word.substring(1) + firstLetter + "ay";
                     } else {
                         return word;
                     }
                 })
                 .collect(Collectors.joining(" "));

    }
}
