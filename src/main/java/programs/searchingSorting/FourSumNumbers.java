package programs.searchingSorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumNumbers {

    public static void main(String[] args) {

//        Find All Four Sum Numbers(GFG)
//        Input: arr[] = [0, 0, 2, 1, 1], k = 3
//        Output: [0, 0, 1, 2]
//        Explanation: Sum of 0, 0, 1, 2 is equal to k.
//        Input:arr[] = [10, 2, 3, 4, 5, 7, 8], k = 23
//        Output: [[2, 3, 8, 10],[2, 4, 7, 10],[3, 5, 7, 8]]
//        Explanation: Sum of 2, 3, 8, 10 = 23, sum of 2, 4, 7, 10 = 23 and sum of 3, 5, 7, 8 = 23.

        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int k = 23;
        System.out.println(Arrays.toString(arr));
        System.out.println("All four sum numbers are: ");
//        System.out.println("findFourSum "+ findFourSumOptimized(arr, k));
        System.out.println("findFourSum " + findFourSumOptimizedWay(arr, k));
    }

    /**
     * A- brute force algorithm O(n^4) algorithm
     * 1- apply four loop for every element and check if the sum of all four elements
     * 2- is equal to target add in set
     * 3- at the end return ArrayList<ArrayList<Integer>> of
     */
    private static ArrayList<ArrayList<Integer>> findFourSum(int[] arr, int x) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == x) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            list.add(arr[l]);
                            list.sort(null);
                            set.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }


    /**
     * B- Optimal Apporacch N(n^3)  ( did not pass all the test case)
     * 1- use the three loop
     * 2- inside the third loop we use the HashSet to store the arr[k]
     * 3- and also check the fourth arr[l]= target-(arr[i]+arr[j]+arr[k])
     * 4-  save the arr[k] in the hashset if the arr[l] exits in hashset then save the all four element in the temp arrayList
     * 5- sort it and then store in set<ArrayList<Integer>>
     * 6- return the final result
     */
    private static ArrayList<ArrayList<Integer>> findFourSumOptimized(int[] arr, int x) {
        int len = arr.length;
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                HashSet<Integer> middleElementSet = new HashSet<>();
                for (int k = j + 1; k < len; k++) {
                    int fourth = x - (arr[i] + arr[j] + arr[k]);
                    if (middleElementSet.contains(fourth)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(fourth);
                        temp.sort(Integer::compareTo);
                        set.add(temp);
                    }
                    middleElementSet.add(arr[k]);
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(set);
        // need to sort that that will not given the answer in sorted way
        return result;
    }

    /**
     * C- Optimized way that pass all the testcase
     * 1- use the 2 for loop and 1 while loop time O(N^3)
     * 2- first loop from i=0 to len and
     * // avoid the duplicates while moving i:
     * if (i > 0 && arr[i] == arr[i - 1]) continue;
     * 3- second for loop j=i+1 to len
     * // avoid the duplicates while moving j:
     * if (j > i + 1 && arr[j] == arr[j - 1]) continue;
     * 4- take l=j+1 and r=len-1  inside that run while(l<r)
     * 5- sum =arr[i]+arr[j]+arr[l]+arr[r]
     * 6- check if the sum==target then we put all arr[i],arr[j],arr[l],arr[r] into the Set<ArrayList<Integer>>
     * // skip the duplicates:
     * while(l<r&&arr[l]==arr[l-1]) l++;
     * while(l<r&&arr[r]==arr[r+1])r--;
     * 7- else if the sum> target it means we need less number so r--
     * 8- else l++ it means we need more number larger number
     * 9- at the end return the result
     */
    private static ArrayList<ArrayList<Integer>> findFourSumOptimizedWay(int[] arr, int target) {
        int len = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < len; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[l]);
                        list.add(arr[r]);
                        result.add(list);
                        l++;
                        r--;
                        // skip the duplicates:
                        while (l < r && arr[l] == arr[l - 1]) l++;
                        while (l < r && arr[r] == arr[r + 1]) r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return result;
    }

}
