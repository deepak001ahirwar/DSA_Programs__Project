package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeWayPartitioning {

    public static void main(String[] args) {
//        int arr[]={1, 4, 3, 6, 2, 1};
        int arr[]={1,  14, 5,  20, 4, 2, 54,
                20, 87, 98, 3,  1, 32};
        System.out.println( "Arr: "+Arrays.toString(arr));
        int a=10;
        int b=20;
//        threewaypartitioning(arr,a,b);
        optimalThreewaypartitioning(arr,a,b);
    }
   /**
     *brouth force apporach
     * 1- first take the three arr that store the element on the basis of condtion
     * 2- (i) if arr[i] < a then store in arr1
     *     (ii) if arr[i] in the range of (a,b) the store in arr2
     *     (iii) if the arr[i] >b store in the arr3
     * 3- at the end combine the array and return it
     */
    public  static  void threewaypartitioning(int arr[],int a,int b) {
        int len = arr.length;
        int arr1 [] = new int[len];
        int arr2 [] = new int[len];
        int arr3 [] = new int[len];
        int i=0, j=0, k = 0;
        for (int x = 0; x < len; x++) {
            if (arr[x] < a) {
                arr1[i++] = arr[x];
            } else if (arr[x] > b) {
                arr3[j++] = arr[x];
            } else {
                arr2[k++] = arr[x];
            }
        }
        Arrays.fill(arr,0);
        System.out.println("Arrr1 :"+Arrays.toString(arr1));
        System.out.println("Arrr2 :"+Arrays.toString(arr2));
        System.out.println("Arrr3 :"+Arrays.toString(arr3));
        int q=0;
        int n=0;
        // for first arr1
        while(n<i){
            arr[q++]=arr1[n++];
        }
        // second array
        int p=0;
        while(p<k){
            arr[q++]=arr2[p++];
        }
        // third array
        int l=0;
        while(l<j){
            arr[q++]=arr3[l++];
        }
        System.out.println("Final Array"+Arrays.toString(arr));
    }

    /**
     *  Second Apporach  Optimal dutch Natinal flag Algo
     *  divide the arrary into 3 parts
     *
     *  swap(arr[mid],arr[low])    swap( arr[mid],arr[high])          mid++
     *  low++, mid++               high--
     * ------------------------ < a ----------- | a, b| ----------(> b)-----------
     *  1- take the two pointer low =0 mid=0, high = n-1;
     *  2- itrate the loop until the mid<=high  repeate the 3
     *  3-  check (i) if arr[mid] <a then
     *       swap (arr[mid],arr[low]) ,
     *       low++ , mid++
     *      (ii) else if arr[mid] >b
     *          swap (arr[mid], arr[high])
     *          high --
     *       (iii) mid++
     */
    public static void optimalThreewaypartitioning(int[] arr, int a, int b) {
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] < a) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] > b) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }
        System.out.println("Final Array" + Arrays.toString(arr));
    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
