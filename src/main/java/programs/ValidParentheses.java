package programs;
import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {
//        Input: {([])}
//        Output: true
//        Explanation: { ( [ ] ) }. Same colored brackets can form balanced pairs,
//                with 0 number of unbalanced bracket

        /**
         * 1- use the stack to solved this problem
         * 2- convert into charArray itrate and onces comes { ,(,[ push into the stack
         * 3- if the strCharA(i) is },),] then first check is stack empty then return false
         * 4- after that check if the str.pop!= {,(,[ the return false
         * 5- at the end check if the stack is empty then return true otherwise return false
         *
         */
        System.out.println(isValid());
        }
    
    public  static boolean isValid() {
        String str="()[]{}";
        String  startBrakets = "{([";
        String  endBrakets = "})]";

        Stack<Character> stc =new Stack<>();
        for(int i=0;i<str.length();i++){
            // push all first parentheses
//            if(str.charAt(i)=='('){
//                stc.push('(');
//            }else if(str.charAt(i)=='{'){
//                stc.push('{');
//            }else if(str.charAt(i)=='['){
//                stc.push('[');
//            }
//            // pop the value and
//            Character pop = stc.pop();
//            if(str.charAt(i)==')'){
//                    if(stc.empty()){
//                        return false;
//                    }
//                if(stc.pop()!='('){
//                    return false;
//                }
//            }else if(str.charAt(i)=='}'){
//                if(stc.empty()){
//                    return false;
//                }
//                if(stc.pop()!='{'){
//                    return false;
//                }
//            } else if(str.charAt(i)==']'){
//                if(stc.empty()){
//                    return false;
//                }
//                if(stc.pop()!='['){
//                    return false;
//                }
//            }



                // Optimized

                // push If got the startbrackets
                if(startBrakets.contains(String.valueOf(str.charAt(i)))){
                    stc.push(str.charAt(i));
                }
                if(endBrakets.contains(String.valueOf(str.charAt(i)))) {
                    if (stc.empty()) {
                        return false;
                    }
                    if (str.charAt(i) == ')') {
                        if (stc.pop() != '(') {
                            return false;
                        }
                    } else if (str.charAt(i) == '}') {
                        if (stc.pop() != '{') {
                            return false;
                        }
                    } else if (str.charAt(i) == ']') {
                        if (stc.pop() != '[') {
                            return false;
                        }
                    }
                }

            }
        // If the stack is not empty then it means there are unmatched brackets
        if(stc.empty()){
            return true;
        }
        else{
            return false;
        }
    }
    }

