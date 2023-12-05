
public class MaxMinEleArray {

	public static void main(String[] args) {

//		Input: arr[] = {3, 5, 4, 1, 9}
//		Output: Minimum element is: 1
//		Maximum element is: 9
		int arr[]= {3, 5, 4, 1, 9};
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("max :"+max+" "+"min : "+min);
		
	}

}
