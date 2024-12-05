package com.example.java8.object;

public class StringRunner {

    public static void main(String[] args) {

        /**
         * String Concept for string pool and  heap allocation
         */
        String s1 = "hello";
        String s2 = "hello";
        String s4 = "world";
        System.out.println(s1 == s2);  // Output: true
        System.out.println(s1.equals(s2));  // Output: true

        System.out.println(s1 == s4);  // Output: false
        System.out.println(s1.equals(s4));  // Output: false

        System.out.println(" \n ");
        System.out.println("======= String in heap ===========");
        String s3 = new String("hello");
        String s5 = new String("world");
        System.out.println(s1 == s3);  // Output: false
        System.out.println(s1.equals(s3));  // Output: true

        System.out.println(" \n ======= String concat ===========");

        s1.concat("world");
        String s6 = s1.concat("world");

        System.out.println("s1 After concat :"+s1);
        System.out.println("s6 After concat :"+s6);
        // String Buffer and  String Builder
        /**
         * String Buffer is thread safe
         */
        System.out.println(" \n ======= String Buffer ===========");
        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("hello");
        System.out.println(sb1 == sb2);  // Output: false
        System.out.println(sb1.equals(sb2));  // Output: true

        System.out.println(" \n ======= String Builder ===========");
        StringBuilder sb3 = new StringBuilder("hello");
        StringBuilder sb4 = new StringBuilder("hello");
        System.out.println(sb3 == sb4);  // Output: false
        System.out.println(sb3.equals(sb4));  // Output: true
    }
}
