package programs.array;
import java.util.Arrays;

public class ShiftzerosEnd {

	public static void main(String[] args) {

		// Input : arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
		// Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};
		// Input : arr[] = {1, 2, 0, 0, 0, 3, 6};
		// Output : arr[] = {1, 2, 3, 6, 0, 0, 0};

		int arr[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
		System.out.println(shiftzerosEnd(arr));
		/*
		 * Approach-
		 *  1- inlize j=0;for maainting zero
		 *  2- first itrate the arrays and
		 * replace the non zero elemnt with index of j and j++ 
		 * 3-when loop end we start
		 * the index of j and put all index zero
		 * 
		 * 
		 */

	}

	public static int[] shiftzerosEnd(int arr[]) {
		int len = arr.length;
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] != 0) {
				arr[j] = arr[i];
				j++;
			}
		}
		// pull all index zero from index zero
		for (int k = j; k < len; k++) {
			arr[k] = 0;
		}
		System.out.println(Arrays.toString(arr));

		return null;
	}

}
