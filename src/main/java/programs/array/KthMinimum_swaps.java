package programs.array;

import java.util.Arrays;

public class KthMinimum_swaps {


    public static void main(String[] args) {

        int arr[] = {2, 7, 9, 5, 8, 7, 4};
        int k = 6;
        System.out.println("Array : " + Arrays.toString(arr));
//        System.out.println("kthMinimum_swaps: " + kthMinimum_swaps(arr, k));
        System.out.println("kthMinimum_swaps: " + optimalKthMinimum_swaps(arr, k));
    }

    /**
     *  Naive Approach -
     *  1- first find the how many numbers which is less or equal to k
     *  2- itrate the subarray of size count  and find the how many swap required
     *  3 - take care that i is not grether the (n-count) and for j <=(count+i-1)
     *  4- store the temp_swap and min_swap both the min value
     *
     */
    public static int kthMinimum_swaps(int arr[], int k) {
        int min_swap = Integer.MAX_VALUE;
        int len = arr.length;
        int count = 0;
        // find the number of count which is equal and less the k
        for (int i = 0; i < len; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }
        // itrate the subarray of k size and check , number of swap
        // at the store in min_swap  return
        for (int i = 0; i < len && i <= (len - count); i++) {
            int tempSwap = 0;
            for (int j = i; (j <= (count + i - 1)) && j < len; j++) {
                if (arr[j] > k) {
                    tempSwap++;
                }
            }
            if (tempSwap > 0) {
                min_swap = Math.min(tempSwap, min_swap);
            } else {
                min_swap = 0;
            }
        }
        return min_swap;
    }

    /**
     * Optimal Apporach use the sliding windows sue to subarray
     *
     * 1- first identify the how many elemnt is equal and less the k store in count
     * 2- find out the bad element of size count store (like first window of find the bad elemnt )
     * 3- take 2 pointer i =0 and j =count that use to manintain the windows
     * 4- check if the arr[i] is bad element the remove from windows and decrease the bad_Count
     * 5- again check if the arr[j] is bad val the store in windows incease the bad_count
     * 6- store the in ansCount and bad_count min value
     */
    public   static int optimalKthMinimum_swaps(int arr[],int k) {
        int len = arr.length;
        int min_swap = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }
        int bad_count = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad_count++;
            }
        }
        min_swap = bad_count;
        for (int i = 0, j = count; j < len; i++, j++) {
            if (arr[i] > k) {
                bad_count--;
            }
            if (arr[j] > k) {
                bad_count++;
            }
            min_swap = Math.min(bad_count, min_swap);
        }
        return min_swap;
    }
}
