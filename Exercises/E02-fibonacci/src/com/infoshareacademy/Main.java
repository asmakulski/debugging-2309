package com.infoshareacademy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Fibonacci fibonacci = new Fibonacci();

	    System.out.print("n = ");
	    Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();

        long fibNumber = fibonacci.get(n);
        System.out.println("n-th Fibonacci number is " + fibNumber);
    }
}
