package programs.array;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangleMatrix {


    public static void main(String[] args) {


        int row = 4, col = 4;
        int M[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        // print 2 D Marirx
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(M[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("maximumRectangleMAtrix : " + maximumRectangleMAtrix(M, row, col));

    }

    /**
     * brouth forach apporaches
     * <p>
     * 1- itrate the row by row and calculate maximum sum of 1 D row
     * 2- onces done the first row add with second row and again calculate the maximum sum of 1D
     * 3- at the end retur the maximum sum
     * 2- calculate the matrix  mazximum use the LargestRectangleHistogram
     */

    public static int maximumRectangleMAtrix(int matrix[][], int row, int col) {
        int maxresult = Integer.MIN_VALUE;
        int height[] = new int[col];
        // itrate the row by row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += matrix[i][j];
                }
            }
            int result = optimallargestRectangle(height);
            if (result > maxresult) {
                maxresult = result;
            }
        }
        return maxresult;
    }


    public static int optimallargestRectangle(int arr[]) {

        int rightsmaller[] = getRightSmaller(arr);
        System.out.println("rightsmaller:  " + Arrays.toString(rightsmaller));
        int leftsmaller[] = getLeftSmaller(arr);
        System.out.println("leftsmaller:  " + Arrays.toString(leftsmaller));
        int len = arr.length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            // Area= height * width(right-left-1)
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
}
