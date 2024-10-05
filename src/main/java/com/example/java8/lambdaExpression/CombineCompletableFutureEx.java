package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineCompletableFutureEx {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		CompletableFuture<String> result = getUserEmail().thenCombine(getWeatherReport(), (e, w) -> {
			System.out.println("sending email to " + e + "with weather report " + w);
			delay(1);
			return e + w;
		});

		System.out.println("Do something ");
		delay(3);
		System.out.println("Final result: " + result.join());
		long endTime = System.currentTimeMillis();
		System.out.println("Total time: " + (endTime - startTime) / 1000);

	}

	public static CompletableFuture<String> getUserEmail() {

		return CompletableFuture.supplyAsync(() -> {
			System.out.println("getUserEmail: " + Thread.currentThread().getName());
			delay(2);
			return "tech.support@rawcubes.com";
		});
	}

	public static CompletableFuture<String> getWeatherReport() {

		return CompletableFuture.supplyAsync(() -> {
			System.out.println("getWeatherReport: " + Thread.currentThread().getName());
			delay(3);
			return "Weather report of city is Delhi";
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
