package programs.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallerCurrentNum {

	public static void main(String[] args) {

		//How Many Numbers Are Smaller Than the Current Numbe
		/***
		 * Input: nums = [8,1,2,2,3]
			Output: [4,0,1,1,3]
			Explanation: 
			For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
			For nums[1]=1 does not exist any smaller number than it.
			For nums[2]=2 there exist one smaller number than it (1). 
			For nums[3]=2 there exist one smaller number than it (1). 
			For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
			Ex
		 */
		/**
		 * Apporach-1
		 * 1- first store in list and sort the element
		 * 2- after sorting we find the index of same  elemnt after sorting 
		 * 3- store into new array
		 */
		int[] nums = { 6, 5, 4, 8 };
		// int n=nums.length;
		// int result [] =new int [n];
		// for(int i=0;i<n;i++){
		// int count=0;
		// for(int j=1;j<n;j++){
		// if(nums[i]>nums[j]&&j!=i){
		// count++;
		// }

		// }
		// result[i]=count;

		// }

		// 1 method
		// Map<Integer, Integer> map = new HashMap<>();
		// int[] copy = nums.clone();

		// Arrays.sort(copy);

		// for (int i = 0; i < nums.length; i++) {
		// map.putIfAbsent(copy[i], i);
		// }

		// for (int i = 0; i < nums.length; i++) {
		// copy[i] = map.get(nums[i]);
		// }
		// System.out.println(Arrays.toString(copy));

		// 2 method
		int len = nums.length;
		int[] result2 = new int[len];
		List<Integer> temp = new ArrayList<>();

		for (int n : nums)
			temp.add(n);

		System.out.println("temp => " + temp);
		Collections.sort(temp);
		System.out.println("after sort temp => " + temp);

		for (int i = 0; i < len; i++) {
			System.out.println("before  " + Arrays.toString(result2));
			System.out.println(nums[i] + "= index " + temp.indexOf(nums[i]));
			result2[i] = temp.indexOf(nums[i]);
			System.out.println("after " + Arrays.toString(result2));
		}

		System.out.println("Finally " + Arrays.toString(result2));

	}

}
