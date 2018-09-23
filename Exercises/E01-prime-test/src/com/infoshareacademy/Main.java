package com.infoshareacademy;

public class Main {

    public static void main(String[] args) {

        for (int number = 2; number <= 30; number++) {
            boolean isPrime = PrimeTester.isPrime(number);

            if (isPrime) {
                System.out.printf("%d PRIME\n", number);
            } else {
                System.out.printf("%d\n", number);
            }
        }
    }
}
