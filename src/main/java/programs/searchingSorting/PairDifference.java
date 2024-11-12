package programs.searchingSorting;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairDifference {

    public static void main(String[] args) {


//        Find Pair Given Difference
//        Input:
//        n = 6
//        x = 78
//        arr[] = {5, 20, 3, 2, 5, 80}
//        Output:
//        1
//        Explanation:
//        Pair (2, 80) have absolute difference of 78.

        int arr[] = {5, 20, 3, 2, 5, 80};
        int x=78;
        System.out.println( getPairDifference(arr,x));
    }

    /**
     * 1- sort the array
     * 2- use two pointer i=0,j=1 and calculate difference arr[j]-arr[i]
     * 3- if the difference is equal to X and i !=j return 1
     * 4- else if the difference is less than X  increment j++
     * 5-else if the difference is greater than X increment i++
     * 6- at the end return -1;
     */

    private static int  getPairDifferenceOptimal(int arr[],int x) {
        Arrays.sort(arr);
        int len = arr.length;
        int i = 0, j = 1;
        while (j < len && i < len) {
            int diff = arr[j] - arr[i];
            if (diff == x && i != j) {
                return 1;
            } else if (diff < x) {
                j++;
            } else {
                i++;
            }
        }
        return -1;
    }





    /**1- take the set to store the elements
     * 2- itrate the array and add with x search the result exits in set then return 1
     * 3- at the end return -1;
     */
    // Not pass all test cases
    private static int getPairDifference(int[] arr,int x) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(set::add);
//        for(Integer ans: arr){
//            set.add(ans);
//        }
        for (int i = 0; i < len; i++) {
            if (set.contains(arr[i] + x)) {
                return 1;
            }
        }
        return -1;
    }
}
