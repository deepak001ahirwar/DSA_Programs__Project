package programs.array;
import java.util.ArrayList;
import java.util.Arrays;

public class TargetArrayProblem {

	public static void main(String[] args) {

		
		// Create Target Array in the Given Order

		/**
		 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
		Output: [0,4,1,3,2]
		Explanation:
		nums       index     target
		0            0        [0]
		1            1        [0,1]
		2            2        [0,1,2]
		3            2        [0,1,3,2]
		4            1        [0,4,1,3,2]
		 */
		int[] nums = { 0, 1, 2, 3, 4 };
		int[] index = { 0, 1, 2, 2, 1 };

		/***Apporach-1
		 * 
		 * 
		 * 
		 */
		int n = nums.length;
		int target[] = new int[n];
		// Arrays.fill(target,0);
//		for (int i = 0; i < n; i++) {
//			if (index[i] == i) {
//				target[index[i]] = nums[i];
//				System.out.println("in if case" + Arrays.toString(target));
//			} else {
//				int temp = 0;
//				int j = index[i];
//				System.out.println("in else case" + Arrays.toString(target));
//				for (int k = j; k < i + 1; k++) {
//					System.out.println(
//							" before in loop case" + Arrays.toString(target) + " nums " + Arrays.toString(nums));
//					temp = target[k];
//					target[k] = nums[i];
//					nums[i] = temp;
//					System.out
//							.println("after in loop case" + Arrays.toString(target) + " nums " + Arrays.toString(nums));
//				}
//				System.out.println(" case" + Arrays.toString(target));
//				// target[j]=nums[i];
//			}
//		}

//		int[] nums = { 0, 1, 2, 3, 4 };
//		int[] index = { 0, 1, 2, 2, 1 };


		/**
		 * Apporach-2
		 * 
		 */
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			System.out.println("before List Data" + list);
			list.add(index[i], nums[i]);
			System.out.println("after List Data" + list);

		}
		System.out.println("List Data" + list);
		for (int j = 0; j < n; j++) {
			target[j] = list.get(j);
		}
		System.out.println(" Fianlly " + Arrays.toString(target));
	}

}
