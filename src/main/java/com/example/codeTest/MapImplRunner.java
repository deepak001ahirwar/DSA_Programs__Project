package com.example.codeTest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee {

    int empId;
    String empName;
    double salary;
    String department;
    int age;


}
public class MapImplRunner {




    public static void main(String[] args) {

    // 1- simple map
    HashMap<String,String> map = new HashMap<>();


    // 2- Concurrent HashMap
     Map<String, String> convertMap = Collections.synchronizedMap(new HashMap<>());


    //3-  use the  concurrent HashMap
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        // (i) - java 8 forEach
        concurrentHashMap.put("Ram", "CSE");
        concurrentHashMap.put("Gopal", "ME");
        concurrentHashMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        // (ii)- Entry

        for(Map.Entry<String,String> res : concurrentHashMap.entrySet()){
            System.out.println(res.getKey()+" : "+res.getValue());

        }

        // first non repating char

        String input = "swiss";
        HashMap<String,Integer> freq = new HashMap<>();

        for (String ch: input.split("")){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }


        String freqStr= "";
        for(Map.Entry<String,Integer> res:freq.entrySet()){
            if(res.getValue()==1){
                freqStr=res.getKey();
                break;
            }
        }
        System.out.println(freqStr);

        // using java 8


        String str ="swiss";


        Optional<Character> res = str.chars()  // convert into char
                .mapToObj(ch -> (char) ch)  // typecast into char
                .collect(Collectors.groupingBy(num -> num, LinkedHashMap::new, Collectors.counting())) // groupBy
                .entrySet().stream()  // convert into map
                .filter(entry -> entry.getValue() == 1) // filter those value is 1
                .findFirst() // find the first elemnt
                .map(Map.Entry::getKey); // cal the key from map



        // Group Anagram

        String[] words = {"bat", "tab", "cat", "act", "dog"};
        /**
         * 0- take the Map<String,List<String>>  for store the data
         * 1- itrate the str array
         * 2- break in the char Arrays , sort it
         * 3- make the newtemp str
         * 4- check if
         */

        Map<String, List<String>> result = new HashMap<>();

        for(String word:words){
            char [] ch = word.toCharArray();
            Arrays.sort(ch);
            System.out.println(" Sorted Arrary : "+Arrays.toString(ch));
            String temp = new String(ch);
            // 1- approarch
            // result.putIfAbsent(temp, new ArrayList<>());
            // result.get(temp).add(word);

            // 2- using the computeIFabsent
            // result.computeIfAbsent(temp, k -> new ArrayList<>()).add(word);

            // 3- using the simple java
            if (result.containsKey(temp)) {
                List<String> r1 = result.get(temp);
                r1.add(word);
                result.put(temp, r1);
            } else {
                List<String> r2 = new ArrayList<>();
                r2.add(word);
                result.put(temp, r2);
            }

        }

        // cal the max
        int max = result.values().stream()
                .max(Comparator.comparingInt(List::size)).get().size();
        List<List<String>> listStream = result.values().stream().
                filter(strings -> strings.size() == max).toList();
        System.out.println("listStream:  "+listStream.get(0));


      // print the map that has max values
        int size = result.values().stream()
                          .max(Comparator.comparingInt(List::size))
                          .get().size();

        Map<String, List<String>> collect2 = result.entrySet().stream()
                                   .filter(key -> key.getValue().size() == size)
                                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        collect2.forEach((k, v) -> System.out.println(k+ " : "+ v));


        // print the duplicate
        int arr [] = {1,2,3,1,2,4};

        // 1- using the 2 loop
        List<Integer> duplicate = new ArrayList<>();
        int len = arr.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]==arr[j]){
                    duplicate.add(arr[i]);
                }
            }
        }
        // 2- using map
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Arrays.stream(arr).forEach(temp -> {
                    hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
                }
        );
        List<Integer> list = hashMap.entrySet().stream()
                                    .filter(entry -> entry.getValue() > 1)
                                        .map(Map.Entry::getKey).toList();

        // using the stream
        List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                             .entrySet().stream().filter(v -> v.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println("duplicate list1: "+list1);

        System.out.println("duplicate Arrays: "+duplicate);

        // remove the duplicate from the Arrays
        // o/p = 1,2,3,4

        List<Integer> res3  = hashMap.keySet().stream().toList();

        // using the single loop and not use the map
        // 1- sort the arrays
        // 2- itrate the Array and also take another pointer
        // j=0 for mantain the index of unique element
        // 3- check if the arr[i] !=arr[i+1] then update the arr[j] = arr[i] and j++
        // 4- for last index arr[j]= arr[len-1]
        // 5- fill the zero in arr from index j to len
        Arrays.sort(arr);
        int j=0;
        for( int i=0;i<len-1;i++){
            if(arr[i]!=arr[i+1]){
                arr[j]=arr[i];
                j++;
            }
        }
        // for last index
        arr[j]=arr[len-1];
        j++;
        // fill the zero in arr from j to len index
        Arrays.fill(arr,j,len,0);
        System.out.println( " Final Arrays: "+Arrays.toString(arr));

        // problem move zero to end
       int  arr25 [] = {1, 2, 0, 4, 3, 0, 5, 0};
       int len25 = arr25.length;
       int j25=0;
       for(int i=0;i<len25;i++){
           // check if the element not 0
           if(arr25[i]!=0){
               arr25[j25]=arr25[i];
               j25++;
           }
       }
       // fill the
        Arrays.fill(arr25,j25,len25,0);

        System.out.println( " Final Array 0 moved right: "+Arrays.toString(arr25));


        // top K frequent element
        int[] nums = {1, 1,5,5, 1, 3, 2, 2};
        int k = 2;
        // o/p -  1,2

        /**
         * Appoarch is java 8
         * 1- store the freq with ement and sort based on the value tale top k elemnt
         */

        List<Integer> topKElemnt =
                Arrays.stream(nums)
                .boxed()  // convert Stream<Integer> to Stream<Integer>
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
//                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
//                .forEach(System.out::println);
                .toList();

        System.out.println(" Final topKElemnt : "+topKElemnt);

        ///
        System.out.println(" :comparingByValue ");

        Arrays.stream(nums).boxed().collect(Collectors.groupingBy(num->num,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                     .forEach(System.out::println);

        System.out.println(" use the comparingLong function");
        Arrays.stream(nums).boxed().collect(Collectors.groupingBy(num->num,Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparingLong(Map.Entry<Integer,Long>::getValue).reversed())
                .forEach(System.out::println);





        // 2- second the use the priority Queue


        Map<Integer, Long> collect = Arrays.stream(nums)
                                        .boxed()  // convert Stream<Integer> to Stream<Integer>
                                            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        PriorityQueue<Map.Entry<Integer,Long>> queue = new PriorityQueue<>
                (Comparator.comparingLong(Map.Entry::getValue));

//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
//                (a, b) -> b.getValue() - a.getValue()
//        );
        queue.addAll(collect.entrySet());
//        Collections.reverse(queue);

        List<Integer> result2 = new ArrayList<>();
        while (k-- >0){
            result2.add(queue.poll().getKey());
        }

        // correct Apporach to solve th top k frequency problem
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map2.entrySet());
        List<Integer> result3 = new ArrayList<>();
        while (k-- > 0) {
            result3.add(pq.poll().getKey());
        }
        System.out.println(":result2 "+result2 );
        System.out.println(":result3 "+result3 );

        /////////////////////////

        // fetch the max from the list
        int nums2 [] = { 10, 20, 30, 40};

        Integer max2 = Arrays.stream(nums2)
                .boxed()
                .max(Integer::compare)
                .orElse(0);
        System.out.println(max2);

        List<Integer> ls = Arrays.asList(10,20,30,40);
        Integer max3 = ls.stream().max(Integer::compare).orElse(0);
        System.out.println("max3: "+max3);

        //4. Convert a list of strings to uppercase.
        List<String> names = Arrays.asList("alice", "bob");

         names.stream()
                 .map(String::toUpperCase)
                 .forEach(System.out::println);

         String namesArr [] = {"alice", "bob"};
         Arrays.stream(namesArr)
                 .map(String::toUpperCase)
                 .forEach(System.out::println);


//        5. Group strings by their length using  groupingBy()  .
        List<String> namesl = Arrays.asList("Alice", "Bob", "Charlie");

        namesl.stream().collect(Collectors.groupingBy(String::length)).entrySet()
                .forEach(System.out::print);

        // // Output: {3=[Bob], 5=[Alice], 7=[Charlie]}


        //. Find the sum of numbers using  reduce()
        System.out.println(" \\n ");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        int[] number ={1,2,3,4};
        Integer reduce = Arrays.stream(number)
                                        .boxed()
                                        .reduce(0, Integer::sum);

        List<String> wordsl = Arrays.asList("apple", "banana", "apple");
        wordsl.stream().collect(Collectors.groupingBy(num->num,Collectors.counting()))
                .entrySet().forEach(System.out::println);

        String[] wlist ={"apple", "banana", "apple"};
        System.out.println(" \n wlist");
        Arrays.stream(wlist).collect(Collectors.groupingBy(num->num,Collectors.counting()))
                .entrySet().forEach(System.out::println);

        // Joing the str
        System.out.println("Joing the str: ");
        List<String> wordjs = Arrays.asList("Java", "is", "awesome");
        System.out.println(wordjs.stream().collect(Collectors.joining(" ")));

        // sort the Employee base on salary
        List<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee(1, "John", 70000, "Finance", 30));
        emplist.add(new Employee(2, "Alice", 80000, "HR", 28));
        emplist.add(new Employee(3, "Bob", 60000, "IT", 32));
        emplist.add(new Employee(4, "Charlie", 90000, "Finance", 29));
        emplist.add(new Employee(5, "David", 75000, "Finance", 31));

        System.out.println("sort the Employee base on salary : ");
        emplist.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList().forEach(System.out::println);

        // 2. Find all elements starting with "A" in a list.

        List<String> names2 = Arrays.asList("Alice", "Bob", "Annie", "Alex");

        names2.stream().filter(el -> el.startsWith("A")).forEach(System.out::println);

//        14. Flatten a list of lists using  flatMap()  .
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(6, 5),
                Arrays.asList(4, 7, 8)
        );
        System.out.println("   flatMap :  ");
        nestedList.stream().flatMap(List::stream).forEach(System.out::println);

        // 15. Use  Collectors.partitioningBy()  to separate even  and odd numbers.
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> collect1 = numbers3.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));


        System.out.println("partitioningBy:  "+collect1);
        //16. Find the second highest number in a list.
        List<Integer> numbers5 = Arrays.asList(10, 20, 30, 40, 50);

        Integer secondHighestFound = numbers5.stream()
                .sorted(Comparator.reverseOrder()).skip(1)
                .findFirst().orElseThrow(() -> new RuntimeException("No Second highest found "));
        System.out.println("secondHighestFound: "+secondHighestFound);

        System.out.println("groupingBy: Emplyee: ");
        emplist.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().forEach(System.out::println);

        // UnsupportedOperationException
//        List<Integer> arrList = Arrays.asList(1,2,3)  ;
//        arrList.add(5); // UnsupportedOperationException
//        System.out.println( "arrList :"+arrList);

//        List<Integer> toList = Stream.of(1,5,8).toList();
//        toList.add(9);
//        System.out.println( "toList: "+toList);



        // collision concept of java hashMap
        Map<String,Integer> tempMap = new HashMap<>();
        tempMap.put("Aa",1);
        tempMap.put("BB",2);
        System.out.println("tempMap: "+ tempMap);




    }
}