package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AnyAllOfCompletablefutureEx {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

//		CompletableFuture<Void> result = CompletableFuture.allOf(future1(), future2(), future3());

		CompletableFuture<Object> result = CompletableFuture.anyOf(future1(), future2(), future3());

		System.out.println("Do something ");
		delay(1);
		System.out.println("Final result: " + result.join());
		long endTime = System.currentTimeMillis();
		System.out.println("Total time: " + (endTime - startTime) / 1000);

	}

	public static CompletableFuture<String> future1() {

		return CompletableFuture.supplyAsync(() -> {
			System.out.println("future1: " + Thread.currentThread().getName());
			delay(2);
			return "1";
		});
	}

	public static CompletableFuture<String> future2() {

		return CompletableFuture.supplyAsync(() -> {
			System.out.println("future2: " + Thread.currentThread().getName());
			delay(3);
			return "2";
		});
	}

	public static CompletableFuture<String> future3() {

		return CompletableFuture.supplyAsync(() -> {
			System.out.println("future3: " + Thread.currentThread().getName());
			delay(1);
			return "3";
		});
	}

	public static void delay(int second) {

		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
