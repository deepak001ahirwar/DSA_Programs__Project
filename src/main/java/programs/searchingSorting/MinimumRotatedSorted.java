package programs.searchingSorting;
import java.util.Arrays;

public class MinimumRotatedSorted {


    public static void main(String[] args) {
//        Find Minimum in Rotated Sorted Array
//        Input: nums = [3,4,5,1,2]
//        Output: 1
//        Explanation: The original array was [1,2,3,4,5] rotated 3 times
//        int arr[] = {11,13,15,17};
//        System.out.println(Arrays.toString(arr));
//        int index = findMinInRotatedSorted(arr);
//        System.out.println("index: "+index + " value : " +arr[index]);

        // Find Minimum in Rotated Sorted Array with duplicates
        System.out.println();
        int arr[] = {2,2,2,0,1};
        System.out.println(Arrays.toString(arr));
        int index = findMinInRotatedSortedDuplicateElements(arr);
        System.out.println("index: "+index + " value : " +arr[index]);
    }

    /**
     * 1- apply the binary search
     * 2- check the three case
     * 3- (i) the curr[mid] <arr[mid-1] then return mid
     *    it means arr[mid] is min  also condtion check mid>0
     *    (ii) check if the right arrary is sorted then moved left side min element in left side
     *        arr[high] > arr[mid] then high=mid-1
     *    (iii) else case the left arrary is sorted then moved right side min element in right side
     *    move to right low =mid+1;
     */
    private static int findMinInRotatedSorted(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // check if previous element of arr[mid-1] is greater then arr[mid]
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            }
            // check if right array is sorted then move left
            else if (arr[high] > arr[mid]) {
                high = mid - 1;
            }
            // left is sorted move to right
            else {
                low = mid + 1;
            }
        }
        return low;
    }


    /**
     * 1- same the find min algo but extra check the condtion
     * 2- check if the arr[mid] and arr[low] , arr[high] same
     * 3-  then nothing do only low++, high--
     */
    public static int findMinInRotatedSortedDuplicateElements(int [] arr){
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // check if previous element of arr[mid-1] is greater then arr[mid]
           if(arr[mid]==arr[low]&&arr[mid]==arr[high]){
               low++;
               high--;
           }
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            }
            // check if right array is sorted then move left
            else if (arr[high] >= arr[mid]) {
                high = mid - 1;
            }
            // left is sorted move to right
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
