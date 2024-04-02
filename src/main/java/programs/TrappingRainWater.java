package programs;

public class TrappingRainWater {

	public static void main(String[] args) {

		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//			{ 4, 2, 0, 3, 2, 5 };

		System.out.println(tappingwaterBrute(arr));
	}

	public static int tappingwaterBrute(int arr[]) {
		
		/** Algo (Brute force Apporach)
		 * 
		 * 1- irtate the  array and find the leftMax rightMax in array so we can calculate 
		 * the poured water in tap
		 * 2- inside the use the while loop to calculate the LeftMax, max(leftMAx,arr[j])
		 *  and ith to  o index
		 * 3- inside use the while loop to calculate the rightMax , max(rightMax, arr[j]) 
		 * and i th to n index
		 * 4- store the result=result+min(leftMax,rightMAx)-arr[i]
		 * 
		 */
		
		int n = arr.length;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int j = i;
			int leftMax = 0, rightMax = 0;
			// calculate the leftmax
			while (j >= 0) {
				leftMax = Math.max(leftMax, arr[j]);
				j--;
			}
			j = i;
			// cal to rightmax
			while (j < n) {
				rightMax = Math.max(rightMax, arr[j]);
				j++;
			}
			result += Math.min(leftMax, rightMax) - arr[i];
		}
		return result;
	}
	
	
	
	public static int optimaltappingWater(int arr[]) {
		
		/**optimal apporach (2 pointer)
		 * 	
		 * 1- take the left , 0 and right pointer 	n-1
		 * 2- take the leftMax,rightMax 0 
		 * 3- if arr[left]<=arr[right] it means we have to check with left subarray
		 *     (i) check if current element is greater then update the leftMax
		 *     (ii) otherwise result=result+(leftMax-arr[left]) 
		 *     (iii) increase the left++ pointer
		 * 4- if means we have to check with right subarray
		 *      (i) check if current element is greater then update the rightMax
		 *      (ii) otherwise result=result+(rightMax-arr[result]) 
		 *      (iii) decrease the right-- pointer
		 */
		
		int n = arr.length;
		int left = 0, right = n - 1, leftMax = 0, rightMax = 0, result = 0;
		while (left <= right) {
			// left sub array
			if (arr[left] <= arr[right]) {
				if (arr[left] >= leftMax) {
					leftMax = arr[left];
				} else {
					result += leftMax - arr[left];
				}
				left++;
			} // right subarray
			else {
				if (arr[right] >= rightMax) {
					rightMax = arr[right];
				} else {
					result += rightMax - arr[right];
				}
				right--;
			}
		}
		return result;
	}
}
