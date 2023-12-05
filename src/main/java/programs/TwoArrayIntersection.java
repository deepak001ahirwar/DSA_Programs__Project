package programs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoArrayIntersection {

	public static void main(String[] args) {

		/// Given two integer arrays nums1 and nums2,
		// return an array of their intersection.
		// Each element in the result must be unique and you may
		// return the result in any order.
//		Input: nums1 = [1,2,2,1], nums2 = [2,2]
//				Output: [2]
//		int nums1[] = { 7, 1, 5, 2, 3, 6 };
//		int nums2[] = { 3, 8, 6, 20, 7 };
		
		int nums1[] = {3, 4, 5, 5, 10};
		int nums2[] = { 5, 5, 10, 20};

//		System.out.println(Arrays.toString(gettwoArrayIntersectionOptimezed(nums1, nums2)));
		
		System.out.println(Arrays.toString(sortedArrayInterSection(nums1, nums2)));

	}

	public static Integer[] gettwoArrayIntersectionOptimezed(int[] nums1, int[] nums2) {
		// O(N) space is also O(N)
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		Set<Integer> set2 = new HashSet<>();
		for (int j = 0; j < nums2.length; j++) {
			if (set.contains(nums2[j])) {
				set2.add(nums2[j]);
			}
		}
		Integer arrr[] = new Integer[set2.size()];
		int j = 0;
		for (Integer i : set2) {
			arrr[j] = i;
			j++;
		}
		return arrr;
	}

	public static int[] gettwoArrayIntersection(int[] nums1, int[] nums2) {
		// first Apporach O(n2)
		// use the set collections and that will remove the
		// d
		Set<Integer> list = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					list.add(nums1[i]);
				}
			}
		}
		int[] arr = new int[list.size()];
		int j = 0;
		for (Integer in : list) {
			arr[j] = in;
			j++;
		}
		return arr;
	}	
	public static int []  sortedArrayInterSection(int num1[],int num2[]) {
		
		// optimized apporach use 2 pointer when array are sorted	
		int i=0,j=0;
		List<Integer> list= new ArrayList<>();
		while (i < num1.length && j < num2.length) {
			if (num1[i] == num2[j]) {
				list.add(num1[i]);
				i++;
				j++;
			} else if (num1[i] < num2[j]) {
				i++;
			} else {
				j++;
			}
		}		
		int arr[]= new int[list.size()];
		int k=0;
		for(int item: list) {
			arr[k]=item;
			k++;
		}		
		return arr;		
	}

}
