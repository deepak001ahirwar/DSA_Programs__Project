package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsyncroCompFuture {

	public static void main(String[] args) {

		Supplier<String> sup1 = () -> {
			delay(1);
			System.out.println("I am in supplier " + Thread.currentThread().getName());
			return "Hello from Supplier";
		};

		CompletableFuture<String> compObj = CompletableFuture.supplyAsync(sup1);

		System.out.println("I am in Main: " + Thread.currentThread().getName());

		String value = compObj.join();
		System.out.println("Value: " + value);

	}

	public static void delay(int second) {

		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
