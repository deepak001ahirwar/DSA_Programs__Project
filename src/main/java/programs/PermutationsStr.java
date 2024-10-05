package programs;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PermutationsStr {

	public static void main(String[] args) {

		/*
		 * A permutation also called an “arrangement number” or “order,” is a
		 * rearrangement of the elements of an ordered list S into a one-to-one
		 * correspondence with S itself. A string of length N has N! permutations.
		 */

		// Input: S = “ABC”
		// Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”
		/*
		 * Apporach-1 use back tracking and recurssion make the tree and itrate the str
		 * from 0 to len-1 if the l==r then print current str else itrate l to r(len-1)
		 * and call the swap function l to i and again call the permute function
		 */
		String str="ABC";
		getAllPermutaionStr(0,str);
//		System.out.println();
		//		permutions(str,0,str.length()-1);

		
		// arrays types
		
		List<List<Integer>> finalList= new ArrayList<>();
		int arr[]= {1,2};
		int len=arr.length;
		List<Integer> l= new ArrayList<>();
		System.out.println("Final List: "+getPermutationsArray(l,arr,0,len-1,finalList));
		

	}

	public static void  getAllPermutaionStr(int index, String str) {
		// base conditions
		if (index == str.length() - 1) {
			System.out.println("getAllPermutaionStr: " + str);
			return;
		}
		// for every index, swap the element at index with all elements from
		// left side of index
		for (int i = index; i < str.length(); i++) {
			str = swap(str, index, i);
			getAllPermutaionStr(index + 1, str);
			str = swap(str, index, i);
		}
	}


	public static void permutions(String str, int l, int r) {
		// it means reach at last and first and last print str
		if (l == r) {
			System.out.println("Str: "+str);
		}
		// again call the permute function and swap function
		else {
			for (int i = l; i <= r; i++) {
				str=swap(str, l, i);
				permutions(str, l + 1, r);
				str=swap(str, l, i);
			}
		}

	}

	public static String swap(String str, int l, int i) {
		char[] arr=str.toCharArray();
		arr[l]=str.charAt(i);
		arr[i]=str.charAt(l);
		return String.valueOf(arr);
	}
	
	
	public static List<List<Integer>> getPermutationsArray(List<Integer> l2, int arr[], int l, int r, List<List<Integer>> finalList) {

		if (l == r) {
			return finalList;

		} else {
			for (int i = l; i <= r; i++) {
				List<Integer> temp1 = swapArray(arr, l, i);
				if (finalList != null) {
					finalList.add(temp1);
				}
				finalList = getPermutationsArray(temp1, arr, l + 1, r, finalList);
				List<Integer> temp2 = swapArray(arr, l, i);
                if (finalList != null) {
                    finalList.add(temp2);
                }
            }
		}

		return null;

	}
	
	public static List<Integer> swapArray(int arr[], int l, int i) {
		int[] temparr = arr;
		temparr[i] = arr[l];
		temparr[l] = arr[i];
		List<Integer> templist = new ArrayList<>();
		for (Integer itr : temparr) {
			templist.add(itr);
		}
		return templist;
	}

}
