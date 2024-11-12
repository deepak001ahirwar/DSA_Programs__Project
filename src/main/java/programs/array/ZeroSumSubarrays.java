package programs.array;
import java.util.ArrayList;
import java.util.List;

public class ZeroSumSubarrays {


    public static void main(String[] args) {


//        Zero Sum Subarrays
//
//        Input: n = 6, arr[] = {0,0,5,5,0,0}
//        Output: 6
//        Explanation: The 6 subarrays are [0], [0], [0], [0], [0,0], and [0,0].

     int   arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
     int n = arr.length;
     System.out.println("Number of subarrays with zero sum: " + countSubarrays(arr, n));
    }


    // Not good apporach not pass the all test cases
    private static int countSubarrays(int[] arr, int n) {
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
        int count = 0;
        for (List<Integer> res : result) {
            int sum = 0;
            for (int i = 0; i < res.size(); i++) {
                sum += res.get(i);
            }
            if (sum == 0) {
                count++;
            }
        }
        // using java 8

        long count1 = result.stream().mapToInt(
                subArray -> subArray.stream()
                                     .mapToInt(Integer::intValue)
                                     .sum())
                .filter(sum -> sum == 0)
                .count();

        return count;
    }
}
