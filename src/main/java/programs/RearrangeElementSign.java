package programs;
import java.util.Arrays;

public class RearrangeElementSign {

	public static void main(String[] args) {

		/*You should rearrange the elements of nums such that the modified
		      array follows the given conditions:

		    1-Every consecutive pair of integers have opposite signs.
		    2-For all integers with the same sign, the order in which 
		    they were present in nums is preserved.
		    3-The rearranged array begins with a positive integer.

		Return the modified array after rearranging the elements to satisfy 
		     the aforementioned conditions.
		     
		     Input: nums = [3,1,-2,-5,2,-4]
		    		 Output: [3,-2,1,-5,2,-4]
		    		 Explanation:
		    		 The positive integers in nums are [3,1,2]. 
		    		 The negative integers are [-2,-5,-4].
		    		 The only possible way to rearrange them such that they satisfy 
		    		 all conditions is [3,-2,1,-5,2,-4].
		    		 Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4],
		    		 [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or
		    		 more conditions*/
		
		
		// Apporach-1 
		// use 2 pointer i for evenindex and j for odd index 
		// and put add newarray the i and j values index 
		
		
		int nums[]= {3,1,-2,-5,2,-4};
		
		
		System.out.println(Arrays.toString(getrearrangeArray(nums)));
		
	}	

	public static int[] getrearrangeArray(int[] nums) {
		int i = 0, j = 1;
		int[] tempArr = new int[nums.length];
		for (int k = 0; k < nums.length; k++) {
			// even
			if (nums[k] > 0) {
				tempArr[i] = nums[k];
				i = i + 2;
			} else {
				tempArr[j] = nums[k];
				j = j + 2;
			}
		}
		return tempArr;
	}

}
