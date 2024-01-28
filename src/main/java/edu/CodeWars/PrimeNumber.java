package edu.CodeWars;

import java.util.stream.IntStream;

public class PrimeNumber {
    public static boolean isPrime(int num){
        return num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(el -> num % el == 0);
    }
    public static void main(String[] args) {
        System.out.println(isPrime(1));
    }
}
