package com.example.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    }
}
