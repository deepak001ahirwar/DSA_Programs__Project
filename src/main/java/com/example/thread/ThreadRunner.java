package com.example.thread;

public class ThreadRunner {

    public static void main(String[] args) {
//        //1- By extend the thread Class
//        GFGThread thread = new  GFGThread();
//        thread.start();  // Starting the thread.

        // 2- by implement the Runnable Interface
//        MYThread myThread = new MYThread();
//        Thread t1 = new Thread(myThread);
//        t1.start();
//        System.out.println("\n");
//
//
        // BY Java 8 lambda Expression
        System.out.println("===================BY Java 8 lambda Expression ===========================\n");
        Runnable task = () -> {
            System.out.println("Runnable by java 8 " + Thread.currentThread().getName());
        };
        Thread t2 = new Thread(task);
        t2.start();

        // another ways
        Thread t3 = new Thread(()->
                System.out.println("Runnable by java 8 " + Thread.currentThread().getName()));
        t3.start();

        new Thread(task).start();

        new Thread(() -> System.out.println("Direct by class " + Thread.currentThread().getName())).start();



    }


}
class GFGThread extends Thread{

    public void run(){
        System.out.println("Thread is running by Thread Class");
    }
}

class MYThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running BY Runnable Interface");
    }
}
