package programs.searchingSorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLastOccurrences {

    public static void main(String[] args) {

//        First and Last Occurrences
//        Input:
//        n=9, x=5
//        arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
//        Output:
//        2 5
//        Explanation:
//        First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5.

        int [] arr ={1, 3, 5, 5, 5, 5, 67, 123, 125};
        System.out.println("First and Last Occurrences of " + Arrays.toString(arr) + ":");
        int n=9, x=5;
//        System.out.println( Arrays.toString(findFirstlastOccurrence(arr, n, x)));
        System.out.println( Arrays.toString(findFirstLastOccurrenceOptimized(arr, n, x)));
    }

    /**
     *1- brute force Apporach O(N) algorithm
     * 2- first , last , count pointer
     * 3- itrate the loop and check if the current element is equal to target
     * 4- inside that check count ==0 it ,means the first occurrence if true then first = i, count++
     * 5- outside the loop every case  last =i
     * 6- at the end return the arr[first],arr[last]
     */
    private static int [] findFirstlastOccurrence(int[] arr, int n, int target) {
        int first = -1, last = -1, count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                if (count == 0) {
                    first = i;
                    count++;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }


    /**
     * 1- optimized version of
     * 2- use the sorted array and apply binary search
     * 3- there are 3 condtion
     *   (i) if current == target for first occurrence
     *   high= mid-1 index=mid;
     *   or last occurrence low = mid+1, index=mid
     *   (ii) if current < target
     *    then low =mid+1,
     *    (iii) if else
     *    high=mid-1
     */
    private static int[] findFirstLastOccurrenceOptimized(int[] arr, int n, int target) {
        // Binary Search for the first occurrence
        ArrayList<Integer > list = new ArrayList<Integer>();
        if (arr==null || arr.length==0) {
             return new int[]{-1, -1};
//             list.add(-1);
//             list.add(-1);
//             return list;
        }

        int firstIndex = binarySearch(arr, target, true);
        // if the target is not present in the array
        if (firstIndex == -1) {
            return new int[]{-1, -1};
//            list.add(-1);
//            list.add(-1);
//            return list;
        }
        // Binary Search for the last occurrence
        int lastIndex = binarySearch(arr, target, false);
        return new int[]{firstIndex, lastIndex};
//        list.add(firstIndex);
//        list.add(lastIndex);
//        return list;
    }

    private static  int binarySearch(int[] arr, int target, boolean isFirst) {
        int low = 0, high = arr.length-1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // if got the target
            if (arr[mid] == target) {
                // first occurence  of the target
                if (isFirst) {
                    high = mid - 1;
                    index = mid;
                } else {        // last occurence of the target
                    low = mid + 1;
                    index = mid;
                }
            } // if  the target  > current element
            else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
