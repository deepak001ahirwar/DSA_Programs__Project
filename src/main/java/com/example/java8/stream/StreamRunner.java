package com.example.java8.stream;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunner {


    public static void main(String[] args) {



        // 1- How to find duplicate elements in a Stream in Java?
         // I/p-  2, 17, 5, 20, 17, 30, 4, 23, 59, 23
        // output : [17, 23]
        int arr [] ={2, 17, 5, 20, 17, 30, 4, 23, 59, 23};
        Stream<Integer> integerStream = Stream.of(2, 17, 5, 20, 17, 30, 4, 23, 59, 23);

        // remove the duplicate elements
        List<Integer> res = integerStream.distinct().collect(Collectors.toList());
        System.out.println("Unique elements "+res );

        // print only the duplicate elements
        List<Integer> list = Arrays.asList(2, 17, 5, 20, 17, 30, 4, 23, 59, 23);
        Map<Integer, Long> ans = list.stream().collect
                (Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println("Number with grouping ");
        ans.entrySet().forEach(System.out::print);
        List<Integer> list1 = ans.entrySet().stream()
                .filter(a -> a.getValue() > 1)  // filter greater than 1 count
                .map(Map.Entry::getKey) // fetch only keys
                .toList();
        System.out.println();
        System.out.println("Duplicate List: "+list1);

        // combine the result
        list.stream().collect(Collectors.groupingBy(num->num,Collectors.counting())) // grouping the numbers together
                .entrySet().stream() //Convert Map to Stream
                .filter(a->a.getValue()>1) // filter count >1
                .map(Map.Entry::getKey)  // collect keys
                .toList().forEach(System.out::println);

        //2-  filter() print only even numbers
        // I/p- 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        // output : 2, 4, 6, 8, 10
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(" SUM NUMBERS ");
        nums.stream().filter(x -> x % 2 == 0).forEach(System.out::print);

        //3-  map()  and flatMap print  of each number
        /** map() : - transform each element into another stream of obj
         *  flatMap() :- flat nested stream into stream
         *
         */
        // I/p- 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        System.out.println("\n=========Map() and flatMap() ==============");
        List<List<Integer>> mapped =  Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4));
        System.out.println("\nmapped: ");
        List<Stream<Integer>> list2 = mapped.stream().map(List::stream).toList();
        System.out.println("list2: "+list2);
        System.out.println("\nflatMap: ");
        List<Integer> list3 = mapped.stream().flatMap(List::stream).toList();

        // 4 - collect()
        /**
         * collect() method is used to convert a stream into a collection or perform mutable reduction operations
         * like joining strings or summing numbers
         */
        System.out.println("\n========= collect() ==============");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String collect = names.stream().collect(Collectors.joining());
        String collect2 = names.stream().collect(Collectors.joining(", "));
        System.out.println("collect: "+collect);
        System.out.println("collect2: "+collect2);

        List<Integer> list4 = Arrays.asList(1,2,3,4);
        System.out.println("\n========= SummarizingInt() ==============");
        int sum = list4.stream().mapToInt(Integer::intValue).sum();
        System.out.println("mapToInt: "+sum);
        long sum1 = list4.stream().collect(Collectors.summarizingInt(x->x)).getSum();
        System.out.println("SummarizingInt: "+sum1);

        // Compute sum of salaries of employee
        Employee emp1 = new Employee(5,"Alice",250000,"IT",30);
        Employee emp2 = new Employee(2,"Bob",280000,"HR",35);
        Employee emp3 = new Employee(3,"Charlie",320000,"Finance",40);
        Employee emp4 = new Employee(1,"David",350000,"IT",35);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4);

        Integer withMapCollectTotal = employees.stream()
                                                .map(Employee::getSalary)
                                                .mapToInt(x -> x).sum();
        Integer total = employees.stream().collect(Collectors.summingInt(Employee::getSalary));
        Integer total2 = employees.stream().mapToInt(Employee::getSalary).sum();
        System.out.println("Total Salary: "+total);

        // Group employees by department
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        Map<String, Integer> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));

        //5-  findFirst() and findAny()
        /**
         * findFirst() :- return the first element of the stream , null if the stream is empty
         * findAny() :- return the any element of the stream,
         *              especially useful with parallel streams for better performance.
         */
        System.out.println("\n========= findFirst()and findAny() ==============");
        Optional<Employee> first = employees.stream().findFirst();
        Optional<Employee> any = employees.stream().findAny();
        System.out.println("first: " + first + "  " + "any: " + any);
        String empSalary = employees.stream()
                                .filter(x -> x.getSalary() > 280000)
                                .map(Employee::getEmpName)
                                .findFirst().toString();
        System.out.println("Employee with salary > 280000: "+empSalary);

        // 6- reduce() s used to perform aggregation operations like sum, average, or concatenation.
        System.out.println("\n========= reduce() ==============");
        Integer reduceTotal = employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        System.out.println("reduceTotal: "+reduceTotal );
        List<Integer> numss = Arrays.asList(1,2,3,4,5);
        Integer reduceSum = numss.stream().reduce(0, Integer::sum);
        Integer reduceMax = numss.stream().reduce(0, Integer::max);
        System.out.println("reduceSum: "+reduceSum +"  reduceMax: "+reduceMax);

        /**
         * Stream:- stream are the collection of elements that support the functional style processing
         *  intermediate and terminal operations in Stream API
         * Intermediate Operations:- transStream into stream and are lazy  , they return another stream
         *   like  filter(), map(), sorted(),
         * Terminal Operations:- end the stream and produce the result
         *      like  collect(), forEach(), reduce()
         */

        //7-  Can Stream API work with primitive data types
        /**
         * yes - IntStream , LongStream, DoubleStream, FloatStream
         *
         * Stream.generate(): - create the stream from a Supplier
         * Stream.iterate(): - create the stream from a seed value and a function
         */
        System.out.println("==================Stream API work with primitive =====================");
        int sum2 = IntStream.range(1, 5).sum();
        System.out.println("sum2: "+sum2);
        System.out.println("IntStream.iterate() ");
        IntStream.iterate(1,x->x+1).limit(5).forEach(System.out::print);
        System.out.println("generate stream3 :");
        Stream.generate(Math::random).limit(2).forEach(System.out::println);
        // 8- Stream.of() and Arrays.stream()
        /** Stream.of(): - create the stream from a specfic set of values or objects
         *  Arrays.stream():- create the stream from Array
         */
        System.out.println("\n==================Stream.of() and Arrays.stream() =====================");
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);
        int [] arr2 = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        Stream.of(1,2,3,4,5).forEach(System.out::print);

        //9 - parallelStream()
        /**
         * parallelStream(): - create the parallel stream from the stream
         *  Parallel streams are designed to handle large amounts of data and improve performance
         *  by utilizing multiple threads.
         */
        System.out.println("\n==================parallelStream() =====================");
        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5).parallel();
        integerStream2.forEach(System.out::print);
        System.out.println();
        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5);
        list5.parallelStream().forEach(s-> System.out.println(s+" "+Thread.currentThread().getName()));

        //10- sorted() in stream API
        System.out.println("\n========= sorted() ==============");
        // list6.forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);
        List<String> str = Arrays.asList("Ram","Aman","Gopal");
        numbers.stream().sorted().forEach(System.out::print);
        System.out.println();
        str.stream().sorted().forEach(System.out::print); // Use Collectors.toList() in Java 8
        System.out.println(" Emp Sorted by Salary");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);


        //11 -peek()
        /** 1-Primarily used for debugging purposes; it performs an action on each element
         * but does not modify the elements or create a new stream.
         */
        System.out.println("\n========= peek() ==============");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        numbers1.stream().peek(System.out::println);

        // 12 - groupingBy()
        /**
         * The Collectors.groupingBy() method is used to group elements based on a classifier function.
         */
        System.out.println("\n========= groupingBy() ==============");
        List<String> fruits = List.of("apple", "banana", "cherry", "avocado");
        fruits.stream().collect(Collectors.groupingBy(s -> s.charAt(0)))
                .entrySet().forEach(System.out::println);
        List<Integer> integers = List.of(1, 2, 1, 2, 3, 4, 5);
        integers.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().forEach(System.out::print);
        System.out.println(" Group by Emp Department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().forEach(System.out::println);
        System.out.println("Group by Department, Sum Salary ");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                                   Collectors.summingInt(Employee::getSalary)))
                .entrySet().forEach(System.out::println);



    }

}
@Data
class Employee {

    int empId;
    String empName;
    int salary;
    String department;
    int age;

    public Employee(int empId, String empName, int salary, String department, int age) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.department = department;
        this.age = age;
    }


}