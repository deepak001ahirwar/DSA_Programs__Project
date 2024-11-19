package programs.array;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data= {6, -3, -10, 0, 2};
		
		/** 1- Given an array Arr[] that contains N integers 
		(may be positive, negative or zero). 
		Find the product of the maximum product subarray
		Input:
			N = 5
			Arr[] = {6, -3, -10, 0, 2}
			Output: 180
			Explanation: Subarray with maximum product
			is [6, -3, -10] which gives product as 180.
			 **/
		
		// sloution 
		
		// A- Brute Force Approach 
		// 1- first take the 2 loop and itrate the arr
		// 2- calculate the subarray and find the max 
		
		
		// B- optimal solution 
		// 1- calculate the prefix , subfix and find the max value 
		// 2- check the prefix and subfix if zero then assign the prefix and subprix equal 1
		// 3- find the max value 
		// 4- in subfix = subfix* arr[n-1-i]
	
		
		
		System.out.println(maxProduct(data, 5));

	}
	 static long maxProduct(int[] arr, int n) {
        // code here     
        int len=arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = i; j < len; j++) {
                product = product * arr[j];
                max = Math.max(product, max);
            }
        }
        return max;
    
        
    }
	 
	 long maxOptimalProduct(int[] arr, int n) {
	        // code here
	        long max=Integer.MIN_VALUE;
	        long pre_max=1;
	        long sub_max=1;
	        for(int i=0;i<n;i++){
	        	
	        	// check if pre become 0 
	           if(pre_max==0){
	               pre_max=1;
	           }
	            if(sub_max==0){
	                sub_max=1;
	            }
	            pre_max=pre_max*arr[i];
	            sub_max=sub_max*arr[n-1-i];
	        max= Math.max(max, Math.max(pre_max, sub_max));
	        }
	        return max;
	    }

}
