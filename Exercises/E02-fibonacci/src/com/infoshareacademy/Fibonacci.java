package com.infoshareacademy;

/**
 * @author Marcin Kwiatkowski <m.kwiatkowski@int.pl>
 */
public class Fibonacci {

    private long fib(long n) {
        return fib(n - 1) + fib(n - 2);
    }

    public long get(long n) {
        return fib(n);
    }
}
