package programs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {

		int[][] interval = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		System.out.println("Merged array: " + merge(interval));

	}

	public static int[][] merge(int[][] intervals) {

		// first find the numbers of overlap
		// then merge the array and return non overlap

		List<List<Integer>> list = new ArrayList<>();

		int len = intervals.length;
		int i = 0;
		int temp = 1;
		boolean ismerge = false;

		while (i < len - 1) {
			ismerge = false;
			// to identify the overlap index
			while (intervals[i][1] > intervals[temp][0] && temp < len) {
				temp++;
				ismerge = true;
			}

			// it run
			if (ismerge) {
				List<Integer> l1 = new ArrayList<>();
				int[] arr = new int[2];
				arr[0] = intervals[i][0];
				arr[1] = intervals[i + 1][temp - 1];
				l1.add(arr[0]);
				l1.add(arr[1]);
				list.add(l1);
			} else {
				List<Integer> l1 = new ArrayList<>();
				l1.add(intervals[i][0]);
				l1.add(intervals[i][1]);
				list.add(l1);
			}

			i = temp;
			temp++;

			System.out.println("list : " + list);

		}

		// for last index
		List<Integer> l1 = new ArrayList<>();
		l1.add(intervals[i][0]);
		l1.add(intervals[i][1]);
		list.add(l1);

		System.out.println(" final list : " + list);

		return intervals;

	}

}
