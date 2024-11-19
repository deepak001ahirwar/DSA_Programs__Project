package programs.array;



public class DifferenceOfSum_DigitSUM  {

public static void main(String[] args) {
    

	/**Input: nums = [1,15,6,3]
			Output: 9
			Explanation: 
			The element sum of nums is 1 + 15 + 6 + 3 = 25.
			The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
			The absolute difference between the element sum and
			 digit sum is |25 - 16| = 9
	**/
	/***
	 * 
	 * 
	 */
        int [] nums={1,15,6,3};
        int element_sum=0;
        int digit_sum=0;
        int n=nums.length;
		for (int i = 0; i < n; i++) {
			element_sum = element_sum + nums[i];
			if (nums[i] > 9) {
				int data = nums[i];
				int remd = 0;
				while (data > 0) {
					remd = data % 10;
					data = data / 10;
					digit_sum = digit_sum + remd;
				}
			} else {
				digit_sum = digit_sum + nums[i];
			}
		}

         System.out.println(Math.abs(element_sum-digit_sum));


}
}