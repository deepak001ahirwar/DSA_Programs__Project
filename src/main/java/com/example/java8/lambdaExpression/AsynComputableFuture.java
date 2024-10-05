package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsynComputableFuture {

	public static void main(String[] args) {

		// runnable interface

		Runnable run1 = () -> {
			delay(1);
			System.out.println("I am in run1 " + Thread.currentThread().getName());
		};
		
		
		// we can also pass the our thread pool also 
		
		ExecutorService executorService = Executors.newCachedThreadPool();

//		CompletableFuture<Void> comfObj = CompletableFuture.runAsync(run1);
		
		CompletableFuture<Void> comfObj2= CompletableFuture.runAsync(run1, executorService);

		System.out.println("I am in main thared " + Thread.currentThread().getName());

//		comfObj.join();
		comfObj2.join();

	}

	public static void delay(int second) {

		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
