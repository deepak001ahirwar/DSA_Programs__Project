package com.example.thread;

public class OddEvenThreadSeqRunner {


    public static void main(String[] args) {

        /**
         * Print the number throw 1 to 10 by two thread
         * in sequence way
         * 1,2,3,4,5,6,7,8,9,10
         */

        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            // Odd numbers
            for (int i = 1; i <= 9; i += 2) {
                synchronized (obj) {
//                    System.out.println("Odd: " + i);
                    System.out.print( i);
                    obj.notify();
                    try {
//                        if (i < 9) {
//                            System.out.println("Inside the odd wait => " + i);
                            obj.wait();
//                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }
            }
        });
        Thread t2 = new Thread(() -> {
            // Even numbers
            for (int i = 2; i <= 10; i += 2) {
                synchronized (obj) {
//                    System.out.println("Even: " + i);
                    System.out.print(", " + i +" , ");
                    obj.notify();
                    try {
                        if (i < 10) {
//                            System.out.println("Inside the even wait => " + i);
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

        });
        t1.start();
        t2.start();

    }
}
