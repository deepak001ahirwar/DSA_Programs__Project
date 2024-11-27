package com.example.java8.object;

import java.util.Objects;

public class ObjectRunner {


    public static void main(String[] args) {

        /**
         * 1- if we override the equals and hashCode methods
         * 2- hashCode method with like combination of both like name,age
         * 3- override equals  method compare the age && name
         * 4- after that if the object is same the hashCode is same
         */
        Person p1 = new Person("John", 25);
        Person p2 = new Person("John", 25);

        Person p3 = new Person("John", 30);
        Person p4 = new Person("Bob", 30);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println(" == ");
        System.out.println(p1 == p2); // false ( refrence is different)
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        System.out.println(" == ");

        System.out.println(p1 == p3); // false
        System.out.println(" \n ");

        System.out.println("p1.hashCode(): " + p1.hashCode()); // 71751695
        System.out.println("p2.hashCode(): " + p2.hashCode()); // 71751695
        System.out.println("p3.hashCode(): " + p3.hashCode()); // 71751700
        System.out.println("Compare p1 hashcode and p2 hashcode");
        System.out.println(p1.hashCode() == p2.hashCode()); // true
        System.out.println("Compare p1 hashcode and p3 hashcode");
        System.out.println(p1.hashCode() == p3.hashCode()); // false

        // without Overriding the

        /**
         * 1- without overriding the hashCode and equals method
         * 2- by default  hadcode is mathmatically and memory is allocated based so
         * it may be possible the same object has different hash code
         * 3- equals compare the == by reference based
         *   if the obj is same and allocate the different hashCode
         *   and if we compare it like s1.equals(s2) // false
         */
        System.out.println("==================================================");
        System.out.println("  Student  ");
        Student s1 = new Student("John", 25);

        Student s2 = new Student("John", 25);
        Student s3 = new Student("John", 30);
        Student s4 = new Student("Bob", 30);
        System.out.println("p1.equals(p2): " + s1.equals(s2)); // false
        System.out.println(" == ");
        System.out.println(s1 == s2); //false
        System.out.println("p1.equals(p3): " + s1.equals(s3)); // false
        System.out.println(s1 == s3); //false
        System.out.println(" \n ");

        System.out.println("p1.hashCode(): " + s1.hashCode()); // 443308702
        System.out.println("p2.hashCode(): " + s2.hashCode()); // 935044096
        System.out.println("p3.hashCode(): " + s3.hashCode()); // 396180261
        System.out.println("Compare p1 hashcode and p2 hashcode");
        System.out.println(s1.hashCode() == s2.hashCode());  //false
        System.out.println("Compare p1 hashcode and p3 hashcode");
        System.out.println(s1.hashCode() == s3.hashCode()); //false
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // check the reference equality
        if (this == obj) return true;

        // check class type
        if (obj == null || obj.getClass() != getClass()) return false;

        // typeCast to Person
        Person person = (Person) obj;
        return person.age == age && Objects.equals(name, person.name);
    }


    //hashCode based on the name age
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}

class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
