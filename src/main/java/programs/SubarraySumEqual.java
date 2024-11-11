 package programs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraySumEqual {

	public static void main(String[] args) {


//		Subarray Sum Equals K (Leetcode)
//		Input: nums = [1,2,3], k = 3
//		Output: 2
		int arr[] = {1,2,3};
		int k= 3;
		System.out.println(isSubarraySumEqual(arr, k));
		System.out.println(optimalSubArraySumEqual(arr, k));


		/// Zero Sum Subarrays (GFG)

		int[] nums = {1,-1,0};
		int sum = 0;
		// Apporach-1 brute force approach O(n2)
		// use 2 loop and compare each elemnt then check to equal or not
		// Apporach- 2

		System.out.println(isSubarraySumEqual(nums, sum));
		System.out.println(isSubArraySumEqual2(nums,0));

	}
	/**
	 * A- Brouth force apporach O(n2)
	 * 1- apply 2 loop and take 2 two pointer sum and Count
	 * 2- itrate the outer loop  i=0 to n and inside the inlize the sum=0;
	 * 3- itrate the inner loop j=i to n and  check if the arr[i] is equal to k the Count,
	 *      inside the sum = sum+arr[j] and check the sum== k then Count++
	 * 4- return Count
	 */
	public static int isSubarraySumEqual(int[] nums, int k) {
		// 1- brute force
		int Count =0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			if (nums[i] == k) {
				Count++;
			}
			// sum=sum+nums[i];
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == k) {
					Count++;
				}
			}
		}
		return Count;
	}

	/** B- optimal apporach use the HashMap
	 * 1- use the hashMap to store the frequencies
	 * 1.1- put the map with o value and 2 freq to cover all the tests cases
	 * 2- itrate the loop i=0 to n take pointer sum=0,count=0;
	 * 3- inside the loop cal sum = sum + arr[i]
	 * 4- and also check the (sum-k) conatisk key in map if yes then
	 * 5- cal the Count = count+map.get(sum-k)
	 * 6- after that the put into the map sum at value is default 0 or map.get(sum)+1
	 * map.put(sum,map.getOrDefault(sum,0)+1)
	 * 7 - return count
	 */
	private static int  optimalSubArraySumEqual(int[] arr, int k) {
		int count = 0, len = arr.length;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < len; i++) {
			sum += arr[i];
			// check if the sum-k present the increment Count
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			// update the map with updated value
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}


	// this will not cover the negative number
	public static int isSubArraySumEqual2(int [] nums, int k) {
		 int count=0;
		    int sum=0;
		    Set<Integer> set= new HashSet<>();
		    for(int i=0;i<nums.length;i++){
		        sum=sum+nums[i];
		        if(set.contains(sum-k)||(sum-k)==0){
		            count++;
		        }
		        set.add(sum);
		    }
		    return count;
//		return false;
	}




}
