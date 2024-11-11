package programs.array;
import java.util.Arrays;

public class Productpuzzle {


    public static void main(String[] args) {
//Product array puzzle
//        Input: nums[] = [10, 3, 5, 6, 2]
//        Output: [180, 600, 360, 300, 900]
//        Explanation: For i=0, P[i] = 3*5*6*2 = 180.
//        For i=1, P[i] = 10*5*6*2 = 600.
//        For i=2, P[i] = 10*3*6*2 = 360.
//        For i=3, P[i] = 10*3*5*2 = 300.
//        For i=4, P[i] = 10*3*5*6 = 900.

        int [] arr = {10, 3, 5, 6, 2};
//        System.out.println( "Product: " + Arrays.toString(calculateProduct(arr)));
        System.out.println( "Product: " + Arrays.toString(optimalCalculateProduct(arr)));
    }

    /**
     * A- O(n^2) solution simple algorithm
     * 1- take the same size of another array , take j=0 pointer
     * to fill the index of new array
     * 2- itrate the while loop j<n  and inside it take product=1
     * 3- itrate the for loop i=0 to n and check j!=i the cal product = product*arr[i]
     * 4- put the result[j] = product and j++
     */
    private static int[] calculateProduct(int[] arr) {
        int[] result = new int[arr.length];
        int n = arr.length;
        int j=0;
        while(j<n) {
            int product=1;
            for (int i = 0; i < n; i++) {
                if (j!=i) {
                    product=product*arr[i];
                }
            }
            result[j]=product;
            j++;
        }
        return result;
    }


    // this will not cover the all test cases
    private static int [] optimalCalculateProduct(int [] arr){
        int n = arr.length;
        int[] result = new int[n];
        int product = 1;
        int j=0;
        for(int i=0; i<n; i++) {
            if (j != i) {
                product = product * arr[i];
            }
        }
        result[j] = product;
        int tempProduct = 1;
        j++;
        while (j < n) {
            tempProduct = (product/arr[j]) * arr[0];
            result[j] = tempProduct;
            j++;
        }
        return result;
    }


    /**
     * C- optimal that cover the all test cases
     * 1- take the left array and the right array of size n
     * 2- result array to store the output
     * 3- Construct the left array , put the left[0]=1 an
     * 4- itrate the loop i=1 to n and cal the product of arr[i-1] and left[i-1] store in the left[i]
     * 5- same do with right array itrate the loop j=n-2 to j>=0 and  put right[n-1]=1 ,
     * cal the product of arr[j+1] and right[j+1] store in the right[j]
     * 6- in the last loop we multiply the left[i]*right[i] then store in result[i]
     */
    private static int[] optimalCalculateProductWithSpace(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        // construct left array prefix
        left[0] = 1;
        for(int i=1; i<n; i++) {
            left[i] = left[i-1] * arr[i-1];
        }
        // construct right array suffix
        right[n-1] = 1;
        for(int j=n-2; j>=0; j--) {
            right[j] = right[j+1] * arr[j+1];
        }
        // multiply left and right and store in result
        for(int i=0; i<n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

}
