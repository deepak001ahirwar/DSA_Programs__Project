package programs.array;
import java.util.Arrays;

public class KthElementTwoArrays {


    public static void main(String[] args) {
//        K-th element of two Arrays
//        Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
//        Output: 6
//        Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10.
//        The 5th element of this array is 6.

       int k = 5, arr1[] = {2, 3, 6, 7, 9}, arr2[] = {1, 4, 8, 10};
       int result = findKthElement(arr1, arr2, k);
       System.out.println("Kth element is: " + result);
    }

    /**
     * 1- use the result array of n+m size
     * 2- fill the arr1 and arr2 elements in the result array
     * 3- return result[k-1]
     */

    private static int findKthElement(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;
        int result [] = new int[n+m];
        int j=0;
        for(int i = 0; i < n; i++){
            result[j] = arr1[i];
            j++;
        }
        for(int i = 0; i < m; i++){
            result[j] = arr2[i];
            j++;
        }
        Arrays.sort(result);
        return result[k-1];
    }
}
