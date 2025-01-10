package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {


    public static void main(String[] args) {
        // Method that use the
        /**
         * newSingleThreadExecutor(),newFixedThreadPool(5),newCachedThreadPool
         */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // runnable  task to complete
        Runnable t1 = () -> {
            System.out.println("Take 1 is running by Thread " + Thread.currentThread().getName());
        };

        Runnable t2 = () -> {
            System.out.println("Take 2 is running by Thread " + Thread.currentThread().getName());
        };
        executorService.submit(t1);
        executorService.submit(t2);

        /**
         * Callable Interface (Submit a Callable task and retrieve the result)
         */
        Callable<String> callableTask = () -> {
            System.out.println("Callable task is running by Thread " + Thread.currentThread().getName());
            return "Callable task result";
        };
        Future<String> callableRes = executorService.submit(callableTask);
        try {
            System.out.println("Callable result: " + callableRes.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("shutdown the executorService ");
            executorService.shutdown();
        }



    }
}
