package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Fibonacci fibo = new Fibonacci();
        Numbers numbers = new Numbers();

        Scanner in = new Scanner(System.in);
        System.out.println(" Fibonacci().....");
        System.out.print("Enter number of elements in the fibonacci sequence: ");
        int n = in.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.println(i + " : " + fibo.fibonacci(i));
        }

        System.out.println("\nFibonacci().....");
        System.out.print("Enter number of elements in the fibonacci sequence: ");
        int m = in.nextInt();

        for (int i = 0; i <= m ; i++) {
            System.out.println(i + " : " + fibo.fibonacciWithoutRecursion(i));
        }

        //call methods from class Numbers
        numbers.bubbleSort();
        numbers.primeNumber();
        numbers.divisionByModule();


    }
}
