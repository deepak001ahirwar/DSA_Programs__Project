package com.example.java8.lambdaExpression;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingCompfutureEx {

	public static void main(String[] args) {

		boolean error = true;

/*		CompletableFuture<String> compObj = CompletableFuture.supplyAsync(() -> {
			if (error) throw new RuntimeException("Error@Future");
			return "Sucess";
		}).handle((s, e) -> {
			if (e != null) {
				System.out.println(e.getMessage());
				return "null";
			}
			return s;
		});
		System.out.println(compObj.join()); */
		
		
		// other method exceprionally
		CompletableFuture<String> compObj = CompletableFuture.supplyAsync(() -> {
			if (error)
				throw new RuntimeException("Error@Future");
			return "Sucess";
		}).exceptionally((e) -> {
//			if (e != null) {
			System.out.println(e.getMessage());
			return "null";
//			}
//			return s;
		});
		System.out.println(compObj.join());
		
		
	}

}
