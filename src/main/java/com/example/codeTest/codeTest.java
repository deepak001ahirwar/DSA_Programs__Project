package com.example.codeTest;

public class codeTest {

    public static void main(String[] args) {

//        System.out.println(test());
        // Overriding test
        Parent p = new child();
        System.out.println(p.fun(p)); // prints Parent
        System.out.println(p.fun2(p)); // prints Child


        // Another test
        Parent p1 = new Parent();
        p1.getInfo(); // method of Parent class
        Parent p2 = new child();
        p2.getInfo(); // method of child class


        // Another test constructor child
        System.out.println("test constructor child");
        child  child = new child();
        //child.sum(20,20);
        /**
         * compile time error due to parameter mismatch
         */

//        for (int i = 0; 1; i++) {
//            System.out.println("Welcome");
//            break;
//        }
        // compile time error due to wrong 1

//        for (int i = 0; true; i++) {
//            System.out.println(i);
//            continue;
//        }
        // infinite loop


        String str = "pwwkew";
        System.out.println("length o "+str.substring(2,4));
    }
}

class Parent {

    Parent(){
        System.out.println("Parent constructor");
    }
    public String fun(Parent s) {
        return "Parent";
    }

    public String fun2(Parent s) {
        return "Parent";
    }

    protected void getInfo() {
        System.out.println("method of Parent class");
    }

}

class child extends Parent {

    public child(){
        System.out.println("Child constructor");
    }
    public String fun(child s) {
        return "Child";
    }

    @Override
    public String fun2(Parent s) {
        return "Child";
    }

    @Override
    protected final void getInfo() {
        System.out.println("method of child class");
    }

    void sum(int a, long b) {
        System.out.println("First Method executed");
        System.out.println(a + b);
    }

    void sum(long a, int b) {
        System.out.println("Second Method executed");
        System.out.println(a + b);
    }


//    void consume(int a) {
//        System.out.println(a + " consumed!!");
//    }
//
//    static void consume(int a) {
//        System.out.println("consumed static " + a);
//    }



        // Finally block return and override
    public static int test() {
        try {
            int a = 1 / 0;
        } catch (Exception ex) {
            System.out.println("Exception");
            return 2;
        } finally {
            return 1;
        }
    }

}
