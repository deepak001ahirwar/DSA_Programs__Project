package programs;
import java.util.Arrays;

public class SecondlargestElement {

	public static void main(String[] args) {

		/*Input: arr[] = {12, 35, 1, 10, 34, 1}
		Output: The second largest element is 34.
		
		Explanation: The largest element of the 
		array is 35 and the second 
		largest element is 34*/
		
		
		int [] arr= {12, 35, 1, 10, 34, 1};
		
		// Apprach- 1
		// use sorting and return n-2 index values
		// O(nlongn) time complecity 
		
//		System.out.println("SecondMax :"+getSmax(arr));
		
		// apporach- 2
		// use 2 pointer max and smax 
		// itrate and check if curr if > the max 
		// smax=max update smax with max
		// update the max = curr
		// again check curr > smax and curr!=max
		// smax=curr
		// o(n) time complexcity 
		
		System.out.println("Second max: "+getSmaxOptimed(arr));
	
		
	}
	public static int getSmaxOptimed(int arr[]) {
		
		int max=Integer.MIN_VALUE;
		int smax=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			
			// max
			if(arr[i]>max) {
				smax=max;
				max=arr[i];				
			}		
			// If the current element is in between first and second,
			if(arr[i]>smax&&arr[i]!=max) {		
				smax=arr[i];
			}
		}		
		return smax;
		
	}	
	public static int getSmax(int[] arr) {
		Arrays.sort(arr);
		System.out.println("sorted Array: " + Arrays.toString(arr));
		int len = arr.length;
		return arr[len - 2];
	}

}
