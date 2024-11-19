package programs.array;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {


    public static void main(String[] args) {


        int arr[] = {2, 1, 5, 6, 2, 3, 1};
        System.out.println(" Input : " + Arrays.toString(arr));
//        System.out.println("Maximum Area: " + largestRectangleHistogram(arr));
        System.out.println(" optimallargestRectangle: " + optimallargestRectangle(arr));


    }

    /**
     * 2- optimal apporach  using stack for left smaller and right smaller
     * <p>
     * 1- first calculate the left smaller by stack
     * 2- second calculate the right smaller by stack
     * 3- itr   the loop for find the max area
     * 4-  area = height * (rightsmaller -leftsmaller-1);
     */


    public static int optimallargestRectangle(int arr[]) {

        int rightsmaller[] = getRightSmaller(arr);
        System.out.println( "rightsmaller:  "+Arrays.toString(rightsmaller));
        int leftsmaller[] = getLeftSmaller(arr);
        System.out.println( "leftsmaller:  "+Arrays.toString(leftsmaller));
        int len = arr.length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (arr[i] * (rightsmaller[i] - leftsmaller[i] - 1)));
        }

        return maxArea;
    }

    private static int[] getLeftSmaller(int[] arr) {

        int len = arr.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            // check if the current stack element is is lesser the pop
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            // if stack is empty then there is no greater element so store -1
            // else store the next greater element  in result array
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            // at the end store the current element in result array
            stack.push(i);
        }
        return result;
    }

    private static int[] getRightSmaller(int[] arr) {

        int len = arr.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = len - 1; i >= 0; i--) {
            // check if the current stack element is is lesser the pop
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            // if stack is empty then there is no greater element so store -1
            // else store the next greater element  in result array
            if (stack.isEmpty()) {
                result[i] = len;
            } else {
                result[i] = stack.peek();
            }
            // at the end store the current element in result array
            stack.push(i);
        }
        return result;


    }


    /**
     * 1- broute force apporach
     * <p>
     * 1- use the for loop to itrate the array inside the loop we find the leftsmaller from left side
     * and rightsmaller from rightside using while loop
     * 2- calculate the maxArea = max(maxArea, arr[i]*(rightsmaller- leftsmaller -1))
     * // like area=height*width
     * 3- return the maxArea timecomplecty is O(N*N)
     */

    private static int largestRectangleHistogram(int[] arr) {
        int maxArea = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // calculate the left smaller
            int j = i;
            while (j >= 0) {
                if (arr[j] < arr[i]) {
                    break;
                }
                j--;
            }
            // calculate the right smaller
            int k = i;
            while (k < len) {
                if (arr[k] < arr[i]) {
                    break;
                }
                k++;
            }
            maxArea = Math.max(maxArea, arr[i] * (k - j - 1));
        }
        return maxArea;

    }
}
