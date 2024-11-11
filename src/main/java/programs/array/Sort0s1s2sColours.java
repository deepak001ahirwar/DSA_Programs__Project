package programs.array;
import java.util.Arrays;

import static programs.ThreeWayPartitioning.swap;

public class Sort0s1s2sColours {

    public static void main(String[] args) {

//        Sort 0s, 1s and 2s
//        Sort Colors
//        Example 1:
//        Input: nums = [2,0,2,1,1,0]
//        Output: [0,0,1,1,2,2]
        int arr[]={2,0,2,1,1,0};
        sort012(arr);
    }

    /**
     * A- simple Apporach
     * 1- find the count of 0 , 1,2 and put it into same array time in the array
     */
    public static  void sort012(int[] arr) {
        // code here

        int count0 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                count0++;
            else if(arr[i] == 1)
                count1++;
            else
                count2++;
        }
        // set the count 0
        for(int i = 0; i < count0; i++){
            arr[i] = 0;
        }
        // set the count   1
        for(int i = count0; i < count0 + count1; i++){
            arr[i] = 1;
        }
        // set the count 2
        for(int i = count0 + count1; i < arr.length; i++){
            arr[i] = 2;
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * B- Optimal implementation Dutch National Flag algorithm
     * 1- take three pointer low , high,mid
     * 2- low starts at the beginning and is used to place 0s.
     * 3- high starts at the end and is used to place 2s.
     * 4- mid traverses the array
     * 5- itrate the while loop until mid<= high
     * 6- check if arr[mid]==0 the increment low++, mid++  and swap the elemnt of arr[mid],arr[low]
     * 7- check if arr[mid]==1 the increment mid++
     * 8- check if arr[mid]==2 the decrement high--  and swap the elemnt of arr[high],arr[mid]
     */
    public static  void sort012Optimal(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, high, mid);
                high--;
            }
        }
    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
