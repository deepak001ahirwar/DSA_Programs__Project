import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {

	 // use the bubble sorting simple sorting
		
		int arr[]= {3,1,9,6,2,4,7,10,5};
				
		System.out.println(Arrays.toString(bubblesort(arr)));
		
	}
	
	
	
	public static int [] bubblesort(int arr[]) {
		
		boolean swaped;		
		for (int i = 0; i < arr.length-1; i++) {
			swaped = false;
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swaped = true;
				}
			}
			// for no two elemnt swap in inner loop
			if (!swaped) {
				break;
			} 
		}
		return arr;		
	}

}
