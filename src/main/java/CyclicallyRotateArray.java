import java.util.Arrays;

public class CyclicallyRotateArray {

	public static void main(String[] args) {

	
//		Input:
//			N = 1 (number of shift)
//			A[] = {1, 2, 3, 4, 5}
//			Output:
//			5 1 2 3 4
		/**
		 * 
		 *  i=4 
		 *  1,2,3,4,4
		 *  i=3 1,2,3,3,4
		 *  i=2 , 1,2,2,3,4
		 *  i=1 ,         1,1,2,3,4
		 * 
		 *  Apporach-1
		 *  store last index value into temp
		 *  itrate the loop from last index -1 to 0 and 
		 *  shift arr[i] to arr[i+1] 
		 *  at last  store  temp to arr[n-1] 
		 */
		
		int arr[]= {1,2, 3,4,5};
		int num=17;
		int len=arr.length;
		
		// module for find the best solution 
		int maxrotaion=num%len;
		System.out.println("maxrotaion : "+maxrotaion);
		
		System.out.println("Finals Arrays : " + Arrays.toString(rightshift(arr, maxrotaion)));
	}
	public static int[] rightshift(int arr[],int maxrotaion) {
		while(maxrotaion>0) {
		int len = arr.length;
		int temp = arr[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = temp;
		System.out.println("Arrays after rotation : " + maxrotaion + " " + Arrays.toString(arr));
		maxrotaion--;
		}
		return arr;
	}
}
