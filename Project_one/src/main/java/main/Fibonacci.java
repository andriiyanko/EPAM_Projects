package main;

public class Fibonacci {

    // Fibonacci using recursion
    public int fibonacci(int x) {

        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else
            return fibonacci(x - 1) + fibonacci(x - 2);
    }

    //Fibonacci without using recursion
    public int fibonacciWithoutRecursion(int x) {

        if (x == 0 ){
            return 0;
        }
        if (x == 1){
            return 1;
        }

        int previous = 0;
        int next = 1;
        int fibo = 1;

        for (int i = 2; i <= x; i++) {
            fibo = previous + next;
            previous = next;
            next = fibo;
        }
        return fibo;
    }

}
