package programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestCommonSubseq {

	public static void main(String[] args) {		
		int arr[]= {34, 2, 7, 23, 31, 38, 13, 11, 37, 19, 45, 6};
//		int arr[]= {0 ,1, 1, 1, 1, 1, 2};

		System.out.println(LongestCommonSub(arr));	
	}	
	// 1- Apporach O(N Log N)
			/**
			 * 1- we first sort the array
			 * 2- remove the duplicate and store in list 
			 * 3- check if the arr[i] and arr[i+1]-1 equals the count++ or element in seq 
			 * 4- when seq break count=1
			 * 5- return Count
			 ***/	
	public static int LongestCommonSub(int arr[]) {	
		System.out.println(" Before "+Arrays.toString(arr));
		Arrays.sort(arr);
		int Count=1;
		int Max=0;
		System.out.println("After Sort: "+Arrays.toString(arr));
		Set<Integer> set= new LinkedHashSet<>();
		for(Integer itr:arr) {
			set.add(itr);
		}	
		for (Integer data : set) {
			if (set.contains(data + 1)) {
				Count = Count + 1;
			} else {
				Count = 1;
			}
			Max = Math.max(Max, Count);
		}		
		return Max;
	}	
	// 2- Apporach using the hashing O(N) time and O(N) space 
	/**
	 * 1- Store arr in Set 
	 * 2- check the element is not present in set it means,
	 *  its the first seq element
	 * 3- start the find the all seq until break the seq format 
	 * 4- take temp++ and  Count++ until not break the seq
	 * 5- once breaked the seq update the finalCount and Count
	 * 6- return the FinalCount 
	 */
	public static int OptimalLongestCommonSub(int nums[]) {
		Set<Integer> set = new HashSet<>();
		// store in set
		for (Integer itr : nums) {
			set.add(itr);
		}
		int finalCount = 0;
		for (int i = 0; i < nums.length; i++) {
			// this first element of seq
			if (!set.contains(nums[i] - 1)) {
				int tempCount = 0;
				int temp = nums[i];
				// check until got the subsequnce and increase count
				while (set.contains(temp)) {
					set.remove(temp);
					temp++;
					tempCount++;
				}
				// update the FinalCount
				finalCount = Math.max(tempCount, finalCount);
			}
		}
		return finalCount;
	}

}
