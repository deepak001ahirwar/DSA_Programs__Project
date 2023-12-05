import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {

		int arr[]= {1,2,3,4,6};
		//9,6,4,2,3,5,7,0,1
		
		System.out.println("Array: "+Arrays.toString(arr));
//		System.out.println("getMissingNum: "+getMissingNum(arr));

		System.out.println(getMissingNumBit(arr));
		
	}

	
	public static int getMissingNumBit(int [] nums) {
		// calculate the xor 1 to N	
		// calculate xor of arr element 
		// finally xor of both 		
		int n = nums.length;
        int xor = 0;
        // Calculate XOR of all elements in the array
        for (int num : nums) {
            xor ^= num;
        }     
        System.out.println("xor: allem:"+xor);

        // Calculate XOR of all numbers from 1 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        System.out.println("final xor:"+xor);
        return xor;
		
	}
	
	
	
	
	public static int getMissingNum(int[] nums) {

		int len = nums.length;
		int totalsum = 0;
		for (int i = 0; i <= len; i++) {
			totalsum += i;
		}
		System.out.println("totalsum: " + totalsum);

		int currSum = 0;
		for (int i = 0; i < len; i++) {
			currSum += nums[i];
		}
		int totalsum2 = len * (len + 1) / 2;

		System.out.println("currSum: " + currSum);

		return Math.abs(currSum - totalsum);
	}
}
