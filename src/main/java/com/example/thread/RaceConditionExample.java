package com.example.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionExample {
    // 1- Race Conditions
    /**
     * A race condition occurs when multiple threads access shared data concurrently,
     * leading to inconsistent results. This
     * typically happens when a thread reads a value while another thread is modifying it.
     */
    public static int counter = 0;

    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 5000 ; i++) {
//                counter++;
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                counter++;
//            }
//        });
//
//        // start both thread
//        t1.start();
//        t2.start();
//
//        // join the thread
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            System.out.println(" Thread Interrupt  Exception " + e.getMessage());
//        }
//        System.out.println("Final Counter value: "+counter);

        // the final result should be not same in every condition it may change 5217 like that
        // so to avoid
        /**
         * 1- Use synchronized methods or blocks.
         * 2-  Use atomic variables such as AtomicInteger.
         * 3- Use locks ( ReentrantLock ) for fine-grained control
         */

        // 1-  Use synchronized methods or blocks.
//        Thread t3 = new Thread(() -> {
//            for (int i = 0; i < 5000 ; i++) {
//            increment();
//            }
//        });
//        Thread t4 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                increment();
//            }
//        });
//
//        // start both thread
//        t3.start();
//        t4.start();
//
//        // join the thread
//        try {
//            t3.join();
//            t4.join();
//        } catch (InterruptedException e) {
//            System.out.println(" Thread Interrupt  Exception " + e.getMessage());
//        }
//        System.out.println("synchronized Final Counter value: "+counter);


        // 2- Use locks ( ReentrantLock ) for fine-grained control
//        Thread t5 = new Thread(() -> {
//            for (int i = 0; i < 5000 ; i++) {
//                incrementLock();
//            }
//        });
//        Thread t6 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                incrementLock();
//            }
//        });
//
//        // start both thread
//        t5.start();
//        t6.start();
//
//        // join the thread
//        try {
//            t5.join();
//            t6.join();
//        } catch (InterruptedException e) {
//            System.out.println(" Thread Interrupt  Exception " + e.getMessage());
//        }
//        System.out.println("Lock Final Counter value: "+counter);

        // 3- Use atomic variables such as AtomicInteger
        Thread t7 = new Thread(() -> {
            for (int i = 0; i < 5000 ; i++) {
                atomicInteger.getAndIncrement();
            }
        });
        Thread t8 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.getAndIncrement();
            }
        });

        // start both thread
        t7.start();
        t8.start();

        // join the thread
        try {
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            System.out.println(" Thread Interrupt  Exception " + e.getMessage());
        }
        System.out.println("Atomic Final Counter value: "+atomicInteger);


        // This will run upper version of 19
//        Thread.startVirtualThread(()->{
//            System.out.println(" Running Virtual Thread ");
//        });


    }

    //    1- Use synchronized methods or blocks.
    private static  synchronized void increment (){
        counter++;
    }

    // 2- use ReentrantLock
    private  static final ReentrantLock lock = new ReentrantLock();

    private static void incrementLock() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    // 3- use the atomic
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
}
