import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class CountpairsSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2 Explanation: arr[0] +
		 * arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
		 **/

		// Apporach-1
		/**
		 * use map and store the list then print the size of list
		 * 
		 */

		int arr[] = { 1, 5, 5, 5, 5, 7 };
		int N = 6, K = 10;
		System.out.println(Arrays.toString(arr));
		System.out.println("GetCountSum: " + getCountPairSum(arr, N, K));

	}

	public static int getCountPairSum(int arr[], int len, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

//		List<List<Integer>> list= new ArrayList<>();
		int count =0;
		for(int i=0;i<len;i++) {			
			int rem=target-arr[i];
			if(map.containsKey(rem)) {				
				// List<Integer> innerlist= new ArrayList<>();				
				// innerlist.add(map.get(rem));
				// innerlist.add(i);
				count+=map.get(rem);
				// list.add(innerlist);
			} 
			if(map.containsKey(arr[i])){
			map.put(arr[i], map.get(arr[i])+1);
			}
			else{
			  	map.put(arr[i], 1);
 
			}
			
		

		}

		System.out.println("Count: " + count);
		System.out.println("map: " + map.toString());

		return -1;

	}

}
