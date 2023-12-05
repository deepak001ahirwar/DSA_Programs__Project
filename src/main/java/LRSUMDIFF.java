import java.util.Arrays;

public class LRSUMDIFF {

 
    public static void main(String[] args) {
    
    	/**
    	 * 
    	 * Input: nums = [10,4,8,3]
			Output: [15,1,11,22]
			Explanation: The array leftSum is [0,10,14,22] and 
			the array rightSum is [15,11,3,0].
	The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|]
			 = [15,1,11,22].
    	 * 
    	 * 
    	 */
		int nums[] = {10,4,8,3};
		int n = 2;
		int arr[] = new int[2 * n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			arr[j] = nums[i];
			arr[j + 1] = nums[i + n];
			j = j + 2;
		}
		System.out.println(Arrays.toString(arr));

}




    
}
