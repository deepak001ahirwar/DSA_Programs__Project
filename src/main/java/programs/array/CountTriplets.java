package programs.array;
import java.util.Arrays;

public class CountTriplets {


    public static void main(String[] args) {
//        Count triplets with sum smaller than X
//        Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
//        Output: 4
//        Explanation: Below are triplets with sum less than 12 (1, 3, 4), (1, 3, 5), (1, 3, 7) and (1, 4, 5).
        int arr[]={-2, 0, 1, 3};
        int sum= 2;
        System.out.println("Count of triplets is "+ countTriplets(arr, sum));
    }
    /**
     * Function to count triplets with sum smaller than the given sum
     * 1- use the 3 loop brouth forch apporach
     */
    private static int countTriplets(int[] arr, int sum) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] < sum) {
                        count++;
                    }
                }
            }
        }
            return count;  // Converting count to string for returning it from main function.

    }

    /**
     *
     */
    long countTripletsOptimal(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n-2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tempSum =(int) (arr[i] + arr[j] + arr[k]);
                if (tempSum < sum) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}
