package programs;
import java.util.HashSet;
import java.util.Set;

public class SubarraySumEqual {

	public static void main(String[] args) {

		int[] nums = {1,-1,0};
		int sum = 0;

		// Apporach-1 brute force approach O(n2)
		// use 2 loop and compare each elemnt then check to equal or not

		// Apporach- 2

//		System.out.println(isSubarraySumEqual(nums, sum));
		System.out.println(isSubArraySumEqual2(nums,0));

	}

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

	public static boolean isSubarraySumEqual(int[] nums, int sums) {
		// 1- brute force
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			if (nums[i] == sum) {
				return true;
			}
			// sum=sum+nums[i];
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
