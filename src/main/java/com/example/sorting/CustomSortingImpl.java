package com.example.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSortingImpl {


    public static void main(String[] args) {


        List<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee(1, "John", 70000, "Finance", 30));
        emplist.add(new Employee(2, "Alice", 80000, "HR", 28));
        emplist.add(new Employee(3, "Bob", 60000, "IT", 32));
        emplist.add(new Employee(4, "Charlie", 90000, "Finance", 29));
        emplist.add(new Employee(5, "David", 75000, "Finance", 31));

        System.out.println(" Employee List :" );

        emplist.forEach(emp -> {
                    System.out.print(emp.empId + ", " + emp.empName + ", " + emp.salary + ", " + emp.department + ", " + emp.age);
                    System.out.println();
                }
        );
        // compare based on name
      /**  Collections.sort(emplist, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.empName.compareTo(o2.empName);
            }
        });
        System.out.println("Sorted byNAme Employee List :" );
        emplist.forEach(emp -> {
                    System.out.print(emp.empId + ", " + emp.empName + ", " + emp.salary + ", " + emp.department + ", " + emp.age);
                    System.out.println();
                }
        );


        Collections.sort(emplist, (a,b)-> Double.compare(a.salary, b.salary));
        System.out.println("Sorted bySalary Employee List :" );
        emplist.forEach(emp -> {
                    System.out.print(emp.empId + ", " + emp.empName + ", " + emp.salary + ", " + emp.department + ", " + emp.age);
                    System.out.println();
                }
        );

        Collections.sort(emplist, Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.println("Sorted   in Reverse bySalary Employee List :" );
        emplist.forEach(emp -> {
                    System.out.print(emp.empId + ", " + emp.empName + ", " + emp.salary + ", " + emp.department + ", " + emp.age);
                    System.out.println();
                }
        );
        **/

        // Map with single Emp


        // Map with mutiple List<Emp>



    }


}

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
