import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MaximumSubarray {
    

    public static void main(String[] args) {
        
    	
    	
    	/** 
    	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    	Output: 6
    	Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    	Approach -
    	Initialize:
    	    max = INT_MIN
    	    sum = 0
    	Loop for each element of the array
    	  (a) sum = sum + a[i]
    	  (b) if(max < sum)
    	        max = sum
    	  (c) if(sum < 0)
    	         sum = 0
    	return max
    	 */
    	
		int[] nums = { 5, 4, -1, 7, 8 };
		// // out put The subarray [5,4,-1,7,8] has the largest sum 23.
		int n = nums.length;
		int maxsum = 0;
		int prev_Max = 0;
		maxsum = nums[0];
		prev_Max = nums[0];
		// 1 method using 2 loop
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (maxsum < nums[i] + nums[j]) {
					maxsum = maxsum + nums[i] + nums[j];
					prev_Max = maxsum;
				} else {
					prev_Max = maxsum;
					break;
				}
			}
		}
		System.out.println("MAx sum" + maxsum + " " + " prev_Max " + prev_Max);

	}

}
