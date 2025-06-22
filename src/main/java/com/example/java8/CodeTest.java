package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeTest {

    public static void main(String[] args) {

        // ArrayList,LinkedList, Set ,LinkedHashSet

        List<String> lines = new ArrayList<String>();
        lines.add("Ram");
        lines.add("Shyam");
        lines.add("Gopal");
        lines.add("Mohan");


        List<Integer> numlist = new ArrayList<Integer>();
        numlist.add(5);
        numlist.add(10);
        numlist.add(1);
        numlist.add(20);
        numlist.add(15);

        Map<Integer, String> map = new HashMap<Integer, String>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();

        map.put(0, "first");
        map.put(1, "second");
        map.put(0, "third");
        map.entrySet().forEach(s->{
            System.out.println(s.getKey() + " : " + s.getValue());
        });
        map2.put(null, 0);
        map2.put("first", 1);
        map2.put(null, 2);
        System.out.println("map2: " + map2);

        //

        int arr[] = {2,1,15,2,1,6,7,8,2};

        // output should be 2=> 3  most frequncy

        /**
         * if we use the Arr [] then use to convert the ArrayList
         * Arrays.asList()
         */

        // wrong way
//        Map.Entry<int[], Long> longEntry = Arrays.asList(arr).stream()
//                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
//                .entrySet().stream().sorted().findFirst().get();
//        System.out.println( "longEntry: "+ Arrays.toString(longEntry.getKey()) +" "+"longEntry value: "+longEntry.getValue());


        Map.Entry<Integer, Long> integerLongEntry = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet().stream().skip(1).max(Map.Entry.comparingByValue()).get();
        System.out.println("integerLongEntry: "+integerLongEntry.getKey()+"  "+"integerLongEntry: "+integerLongEntry.getValue());

        // seocnd higest
        Map.Entry<Integer, Long> integerLongEntry1 =
                Arrays.stream(arr).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                                                        .entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                                                        .skip(1).findFirst().get();
        System.out.println("integerLongEntry1: "+integerLongEntry1.getKey()+" "+"integerLongEntry1: "+integerLongEntry1.getValue());


        // otherway to do by the comparingByvalye
                        Arrays.stream(arr).boxed()
                                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                                                .forEach(System.out::println);



    }
}
