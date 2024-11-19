package programs.array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

//        long[] result = new long[5];

        int arr[] = {6, 8, 0, 1, 3};
        int n = 5;
        System.out.println( " Arrays " + Arrays.toString(arr) + "");
//        System.out.println(" nextGreaterElements: "+ Arrays.toString(nextGreaterElements(arr,n)));

        System.out.println(" nextGreaterElements: "+ Arrays.toString(optimalnextGreatherElement(arr,n)));



    }
    /**2- optimal algorithm use the stack to find out the next greater element
     * O(N) with space complexity O(N)
     * 1- use the stack to find the next greater element
     * 2- start from end  of array checking the current element with top of stack
     * 3- if current element is < top of stack
     * 4- then store in result array push current element in stack
     * 5- else pop the elemnt until got the greater element or stack is empty
     */

    public  static  int [] optimalnextGreatherElement( int arr[], int len){

        int[] result = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=len-1; i>=0; i--){
            // check if the current stack element is is lesser the pop
            while(!stack.isEmpty() && arr[i]>=stack.peek()){
                stack.pop();
            }
            // if stack is empty then there is no greater element so store -1
            // else store the next greater element  in result array
            if(stack.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }
            // at the end store the current element in result array
            stack.push(arr[i]);
        }
        return result;
    }





    /** O(N*N)
     * 1- brute force apporach using 2 loop and check
     * 2- from current position element  to end is  elemnt is greater or not
     * 3- onces reach at end store in the result array
     *
     */
    public static int []  nextGreaterElements(int [] arr, int len){
        int[] result = new int[len];
        Arrays.fill(result, -1);
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                if(arr[j]>arr[i]){
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }
}
