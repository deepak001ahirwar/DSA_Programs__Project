package programs;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RotateArray {

	public static void main(String[] args) {

		/**Apporach-1
		 * store into temp arr[0]
		 * irtate from 1 to last index and 
		 * shift arr[i+1] to arr[i] 
		 * at last temp to arr[n-1] 
		 * 
		 */
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		//output is 0 1 2 4 5 6 7 
		int index = 4;
		System.out.println(rotateArray(arr, index));
	}

	public static int[] rotateArray(int arr[], int index) {
		// //1 apporch using the extra Array
		// int temparr [] = new int[arr.length];
		// int j=0;
		// for(int i=index;i<arr.length;i++){
		// temparr[j]=arr[i];
		// j++;
		// }
		// for(int k=0;k<index;k++){
		// temparr[j]=arr[k];
		// j++;
		// }

		// 2 using collection deque
		Deque<Integer> que = new ArrayDeque<>();
		for (int data : arr) {
			que.add(data);
		}
		// reove from start aand add in last element
		for (int i = 0; i < index; i++) {
			int temp = que.remove();
			que.addLast(temp);
		}
		// String str [] = new String[que.size()];
		// int finalarray [] = que.toArray(str);
		// // System.out.println(Arrays.toString(que)));

		// rotate by one one
		int p = 1;
		int n = arr.length;
		while (index>0) {
			int temp = 0;
			temp = arr[0];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i + 1];
			}
			arr[n - 1] = temp;
			index--;
		}

		return null;

	}

}
