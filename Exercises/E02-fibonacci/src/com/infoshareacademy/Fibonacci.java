package com.infoshareacademy;

/**
 * @author Marcin Kwiatkowski <m.kwiatkowski@int.pl>
 */
public class Fibonacci {

    private long fib(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public long get(long n) {
        return fib(n);
    }
}
