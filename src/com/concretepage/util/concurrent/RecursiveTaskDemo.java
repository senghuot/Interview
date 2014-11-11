package com.concretepage.util.concurrent;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo {
	
   public static void main(String[] args) {
		FibonacciCal fibonacciCal = new FibonacciCal(12);
		ForkJoinPool pool = new ForkJoinPool();
		int i = pool.invoke(fibonacciCal);
		System.out.println(i);
	}
   
}