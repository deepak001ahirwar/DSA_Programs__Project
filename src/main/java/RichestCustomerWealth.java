public class RichestCustomerWealth {

    public static void main(String args[]){


    	
    	
    	/***
    	 * 
    	 * Input: accounts = [[1,2,3],[3,2,1]]
			Output: 6
		Explanation:
		1st customer has wealth = 1 + 2 + 3 = 6
		2nd customer has wealth = 3 + 2 + 1 = 6
		Both customers are considered the richest with 
		a wealth of 6 each, so return 6
    	 */
    	
		// 1 brouth force approch O(n2)
		int[][] accounts = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
		int wealth = 0;
		for (int[] arr : accounts) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum = sum + arr[i];
			}
			if (sum > wealth) {
				wealth = sum;
			}
		}
		System.out.println(wealth);

    }


    
}
