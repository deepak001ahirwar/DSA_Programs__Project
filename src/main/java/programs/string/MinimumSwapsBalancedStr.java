package programs.string;

import java.util.Stack;

public class MinimumSwapsBalancedStr {

    public static void main(String[] args) {
//        Minimum Number of Swaps to Make the String Balanced
//        https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
//        Input: s = "][]["
//        Output: 1
//        Explanation: You can make the string balanced by swapping index 0 with index 3.
//        The resulting string is "[[]]"
        String s = "]]][[[";
//        System.out.println(minSwapsToMakeBalanced(s));
        System.out.println(minSwapsToMakeBalancedOptimal(s));
    }

    /**
     * 1- use the stack to solve the problem
     * ( remove the vaild pair count the invaild par and calculate the minimum num of swaps)
     * 2-for open brackets blind push in stack
     * 3- else if comes the close bracket then check if the stack is not empty and
     * stack.peek()  is equal to ']' (close bracket) push in stack (it the invalid pair)
     * 4- else it is vaild pair so simple pop the elemnt
     */
    private static int minSwapsToMakeBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack.push(ch);
            } else {
                // invaild pair or stack empty
                if (stack.isEmpty() || stack.peek() == ']') {
                    stack.push(ch);
                } else {  // vaild pair
                    stack.pop();
                }
            }
        }
        int numberInvalidPair = stack.size();
        int openBrackets = numberInvalidPair / 2;
        return (openBrackets + 1) / 2;
    }

    /**
     * B- optimal Apporach
     * 1- take the 2 pointer open  and close with 0
     * 2- itrate the Str and check if the current char is openbracket then open++
     * 3- in else case again check if the open <=0 it means ( it has invaild openbrackets so )
     * close++
     * 4- else case open --
     */
    private static int minSwapsToMakeBalancedOptimal(String s) {
        int open = 0, closed = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else {
                if (open <= 0) {
                    closed++;
                } else {
                    open--;
                }
            }
        }
        return (closed + 1) / 2;
    }


}
