package programs.array;
import java.util.ArrayList;
import java.util.List;

public class PrintAllSubArrays {

    public static void main(String[] args) {
        int arr[] = { 10, 2, 3, 99, 12, 0 };

//        printAllSubarrays(arr);
        printAllSubarraysOptimized(arr);
    }

    /**1- use the three loop to print the all sub array in the ArraysList O(N3)
     * 1- first loop from i=0 to n
     * 2- second loop from j=i to n
     * 3- third loop from k=i to k<=j
     * 4- print or save the ArrayList
     */
    private static void printAllSubarrays(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            for(int j=i; j < n; j++) {
                List<Integer> list = new ArrayList<Integer>();
                for( int k=i; k <=j; k++) {
                    System.out.print(arr[k] + " ");
                    list.add(arr[k]);
                }
                result.add(list);
                System.out.println(""); // To print new subarray on new line.
            }
        }
        System.out.println(" Final result: "+result);
    }


    /** B- Optimzed way using 2 loop
     *
     *
     */

    private static void printAllSubarraysOptimized(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = i; j < n; j++) {
                System.out.print(arr[j] + " ");
                list.add(arr[j]);
                result.add(new ArrayList<>(list));
            }
            System.out.println("");
        }
        System.out.println( " optimized results: "+result);
    }

}
