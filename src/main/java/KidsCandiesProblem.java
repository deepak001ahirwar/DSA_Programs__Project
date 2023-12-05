import java.util.ArrayList;
import java.util.List;

public class KidsCandiesProblem  {


    public static void main(String args[]){
    	
    	/**
    	 * 
    	 * Input: candies = [2,3,5,1,3], extraCandies = 3
			Output: [true,true,true,false,true] 
			Explanation: If you give all extraCandies to:
			- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
			- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
			- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
			- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
			- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
    	 * 
    	 * 
    	 */
    	
    	
		int[] candies = { 4, 2, 1, 1, 2 };
		int extraCandies = 1;
		int n = candies.length;
		// true,false,false,false,false]
		List<Boolean> arr = new ArrayList<Boolean>();
		int sum = 0;
		int max = 0;
		// find the max before it cover all test cases
		for (int j = 0; j < n; j++) {
			max = Math.max(candies[j], max);
		}
		for (int i = 0; i < n; i++) {
			sum = candies[i] + extraCandies;
			System.out.println("max " + max);
			System.out.println("sum " + sum);
			if (sum >= max) {
				arr.add(i, true);
			} else {
				arr.add(i, false);
			}
			// max=Math.max(sum,max);
			System.out.println("max " + max);
			// max = sum;
		}
		System.out.println("result" + arr);

	}


}