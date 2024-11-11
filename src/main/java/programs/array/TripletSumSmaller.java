package programs.array;
import java.util.Arrays;


public class TripletSumSmaller {

    public static void main(String[] args) {
//        Count triplets with sum smaller than X
//        Input: n = 4, sum = 2, arr[] = {-2, 0, 1, 3}
//        Output:  2
//        Explanation: Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3).
//                Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
//        Output: 4
//        Explanation: Below are triplets with sum less than 12 (1, 3, 4), (1, 3, 5), (1, 3, 7) and (1, 4, 5).

        int sum = 12;
         long arr[] = {5, 1, 3, 4, 7};
        int n = arr.length;
        System.out.println("Count of triplets with sum smaller than " + sum + ": " + countTripletsOptimal(arr, n, sum));
    }

    /**
     * A- Brouth forch Apparoch
     * 1- use the 3 loop and check if the sum of
     * all 3 index is less than increment the counter
     */
    int countTriplets(int arr[],int n, int sum ) {
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] < sum) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    /**
     *B- Optimal Apporach use the 2 pointer approach
     * 0- Sort the Array using Arrays.sort(arr)
     * 1- itrate the loop i=0 to n-2
     * 2- inside the loop take two pointer j=i+1, k = n-1
     * 3- apply the while loop untill the j<k
     * 4- cal the tempSum = arr[i] + arr[j] + arr[k]
     * 5- check if the tempSum < sum then all the elements of j to k are smaller
     * 6- count =count+(k-j)  and j++ increment of middle  // diff of last index and middle index
     * 7- else decrease the last index k--
     * 8 - return count
     */
    private static int countTripletsOptimal(long [] arr, int n, int sum) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tempSum = (int) (arr[i] + arr[j] + arr[k]);
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
