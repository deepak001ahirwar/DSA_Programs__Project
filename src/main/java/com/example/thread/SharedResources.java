package com.example.thread;

public class SharedResources {


    public static void main(String[] args) {

        SharedObj obj = new SharedObj();

        new Thread(()->{
            try {
                System.out.println("Thread 1 is running start ");
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Error at Thread 1 ");
            }
            System.out.println("Thread 1 logic Completed ");
            obj.setFlag(true);
            System.out.println("Flag set by Thread 1 ");
        }).start();


        // Thread 2

        new Thread(()->{
            System.out.println("Thread 2 is start ");
            while (!obj.getIsFlag()){
//                System.out.println("Running in thread 2");
            }
            System.out.println("Thread 2 logic completed ");
        }).start();

        /**
         *  As we update the thread 1 flag true but still thread 2 is not getting the updating value
         *  this problem we called visibility problem
         *  we can solve by volatile keyword
         */
    }
}

class SharedObj {

//    public  Boolean isFlag  = false ;

    // after using the volatile keyword
    private  volatile   Boolean  isFlag  = false ;

    public void setFlag(Boolean flag) {
        isFlag = flag;
    }
    public Boolean getIsFlag(){
        return isFlag;
    }
}
