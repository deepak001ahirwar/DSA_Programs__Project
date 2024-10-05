package com.example.java8.lambdaExpression;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncrounsFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService exteqObj = Executors.newFixedThreadPool(5);

		Callable<String> call = () -> {
			Thread.sleep(1000);
			return "Hello from Call 1 future";
		};

		Future<String> result = exteqObj.submit(call);

		Thread.sleep(1000);

		String message = result.get();

		System.out.println("message: " + message);

		exteqObj.shutdown();

	}

}
