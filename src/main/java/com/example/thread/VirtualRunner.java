package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualRunner {

    public static void main(String[] args) {



        // Virtual thread
        /**
         * *Virtual threads are:
         * User-mode, managed by the JVM
         * Use far less memory (a few KB stack vs 1MB)
         * Scalable to millions of concurrent tasks
         */


        Runnable task = () -> {
            System.out.println(" Running By Virtual Thread task ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

//        Thread t1 = Thread.startVirtualThread(task);
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Done the Virtual Thread ... ");


//        //
//        // This will run upper version of 19
//        Thread.startVirtualThread(()->{
//            System.out.println(" Running Virtual Thread ");
//        });

        // 2- Thread excxuter service run the virtual thread

        ExecutorService pool = Executors.newVirtualThreadPerTaskExecutor();

        try {
            for (int i = 0; i < 10; i++) {
                int id = i;
                pool.submit(() -> {
                    System.out.println("task " + id + " on " + Thread.currentThread());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                });
            }
        }catch (Exception e){
            System.out.println(" Exception are occurs in Virtual Thread ");
        }
            pool.shutdown();

        try {
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Some tasks didn't finish in time.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
