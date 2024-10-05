package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComposeComputableFutureEx {

	public static void main(String[] args) {

		long starttime = System.currentTimeMillis();
		CompletableFuture<String> future = getUserDetails().thenCompose(s -> {
			return getWishList(s);
		});
		System.out.println("do something ");
		delay(4);
		System.out.println("future.join() "+future.join());
		long endtime = System.currentTimeMillis();
		System.out.println("Total time: " + (endtime - starttime) / 1000);
	}

	public static CompletableFuture<String> getUserDetails() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("User Details: " + Thread.currentThread().getName());
			delay(2);
			return "Userdetails: ";
		});

	}

	public static CompletableFuture<String> getWishList(String user) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("getWishList: " + "user: " + user + Thread.currentThread().getName());
			delay(3);
			return "getWishList: ";
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
