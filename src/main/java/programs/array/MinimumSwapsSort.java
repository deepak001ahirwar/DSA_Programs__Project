package programs.array;
import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapsSort {

    public static void main(String[] args) {
        //Minimum Swaps to Sort
        int[] arr = {10, 19, 6, 3, 5};
//        int minSwaps = minSwapsRequired(arr);
        int minSwaps = minSwapsRequiredOptimal(arr);
        System.out.println("Minimum swaps required: " + minSwaps);
    }

    /**
     * A- Brouth forch Apporch
     * 1-  first take the tempArr and copy from original Array
     * 2- sort the tempArr , take the pointer Count =0;
     * 3- itrate the loop int i=0 to N
     * 4- inside the loop check if the temp[i]!= arr[i] ( current element is right places or not
     * 5- first cal the index of tempArray element in original Array indexOf(arr,tempArray[i])
     * 5- write the swap (arr,i,indexOf(arr,tempArray[i]))   and swap the current index element
     * and same elemnt at original Array
     * 6- return the Count;
     */
    private static int minSwapsRequired(int[] arr) {
        int Count = 0;
        int[] tempArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(tempArr);
        for (int i = 0; i < arr.length; i++) {
            // it means the element is not sorted
            if (tempArr[i] != arr[i]) {
                Count++;
                swap(arr, i, indexOf(arr, tempArr[i]));
            }
        }
        return Count;
    }
    private static int indexOf(int arr[], int i1) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i1) {
                return i;
            }
        }
        return -1;  // not found
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 1- same the previous apporch in place of find the indexOf that take O(N) time
     * 2-  use the Map store first time all the original elemnt with their index
     * 3 - inside the  itrate the loop  store the temp = arr[i]
     * 4-  swap ( arr , i, map.get(tempArray[i]))
     * 5- after that update the index of temp -> map.get(tempArray[i])
     * 6- and tempArray[i] -> i  in the map
     * 7- at the last return the Count;
     */
    // Optimal implementation
    public static int minSwapsRequiredOptimal(int[] arr) {

        int Count = 0;
        int[] tempArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(tempArr);

        HashMap<Integer, Integer> tempMap = new HashMap<Integer,Integer>();
        for(int i=0; i<arr.length; i++){
            tempMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            // it means the element is not sorted
            if (tempArr[i] != arr[i]) {
                Count++;
                int temp = arr[i];
                swap(arr, i, tempMap.get(tempArr[i]));
                // update the index of arr[i] and tempArr[i]
                tempMap.put(temp,tempMap.get(tempArr[i]));
                tempMap.put(tempArr[i], i);
            }
        }
        return Count;
    }


}
