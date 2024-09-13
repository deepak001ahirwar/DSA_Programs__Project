package com.example.sorting;

import java.util.*;

public class SortingImpl {

    public static void main(String[] args) {
//        int arr[] = {1, 5, 4, 9, 2, 6};

//        System.out.println("Original Array: " + Arrays.toString(arr));

        // 1- simple sorting
//        Arrays.sort(arr);
//        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // 2- Collections sorting
//        List<String> list = Arrays.asList("Ram", "Shyam","Balram", "Gopal", "Aman");
//        System.out.println(" Array: " + list);
//        Collections.sort(list);  // internally use the comparable Interface
//        System.out.println("Sorted List: " + list);

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("C", "Cat");
//        map.put("B", "small");
//        map.put("D", "Dog");
//        map.put("A", "Apple");
//        // or use the TreeMap
//        System.out.println("Map: " + map);
//        // stored into List Entry.Map
//        List<Map.Entry<String, String>> maplist = new ArrayList<>(map.entrySet());
//        maplist.sort(Map.Entry.comparingByValue()); // comprable
//        maplist.sort(new Comparator<Map.Entry<String, String>>() {     // using anonymous
//            @Override
//            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });

//        maplist.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));  // using Lambda Expression
//        System.out.println(" sorted Maplist "+maplist);
//
//        // use the LinkedHash map to maintain the insertion order
//        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
//        maplist.forEach(o -> sortedMap.put(o.getKey(), o.getValue()));
//
//        System.out.println("Sorted Map by Key: " + sortedMap);







    }
}
