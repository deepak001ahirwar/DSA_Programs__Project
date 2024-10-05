package com.example.java8.lambdaExpression;

public class LambdaExpressionRunner {

    public static void main(String[] args) {

        //LambdaExpression obj = ()-> {return   " Hello Lambda Expression" ;};
        // System.out.println(obj.getExpression());  // Output: Hello Lambda Expression

        LambdaExpression obj2 = () ->{System.out.println(" Hello GetName Expression");};
        obj2.getName();  // Output: HelloGetName Expression
    }
}

interface  LambdaExpression {
    /** AT the time only one abstract method allow in functional Interface
     * If we have to add the functinality then use the default and statci method
     */

//     String getExpression();
     void getName();
}
