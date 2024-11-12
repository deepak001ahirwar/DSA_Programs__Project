package com.example.java8.stream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {


    public static void main(String[] args) {



        // 1- How to find duplicate elements in a Stream in Java?
         // I/p-  2, 17, 5, 20, 17, 30, 4, 23, 59, 23
        // output : [17, 23]
        int arr [] ={2, 17, 5, 20, 17, 30, 4, 23, 59, 23};
        Stream<Integer> integerStream = Stream.of(2, 17, 5, 20, 17, 30, 4, 23, 59, 23);
//        List<Integer> collect = integerStream.distinct().filter().toList();
//        System.out.println("collect"+collect );

    }
}
