package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallbackCompletableFutureExmp {

	public static void main(String[] args) {

		CompletableFuture<Void> compObj = CompletableFuture.supplyAsync(() -> {
			delay(1);
			return "Tech Recepiee ";
		}).thenApply(s -> {
			return "Hello " + s;
		}).thenAccept(s -> {
			System.out.println("Result : " + s);
		});
		
		compObj.join();

	}

	public static void delay(int second) {

		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
