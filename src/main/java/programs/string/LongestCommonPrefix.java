package programs.string;
import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println("strs: " + Arrays.toString(strs));
//		System.out.println("longestCommonPrefix: " + longestCommonPrefix(strs));
		/* 1- Optimal Apporach
		 * We will iterate over the first string, comparing each character with the characters of the other strings.
         * If we find a mismatch, we will return the substring up to that point. s=s.substring(0, s.length()-1)
         * If we reach the end of the first string, we will return the entire first string as the common prefix.
         */
		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(s) != 0) {
				s = s.substring(0, s.length() - 1);
				System.out.println(" SUbStr: " + s);
			}
		}
		System.out.println(" prefix: "+s);
//		System.out.println(longestCommonPrefix2(strs));
	}

	/**
	 * 1- take the 2 pointer firstStr , secondStr that store the smallest , largest str from string array
	 * 2- compare the 2 string with firstStr with secondStr element
	 * 3- inside the compare check if the firstStr char is not equal to the secondStr char then break
	 * 4- outside the if we containate the str prefix += firstStr.charAt(i)
	 * 5- return prefix
	 */
	public static String longestCommonPrefix2(String[] str) {
		// first find the smallest and secondsmalest
		String firststr1 = "";
		String secondstr2 = "";

		// first apporach sort and find first and last element
		Arrays.sort(str);
		firststr1 = str[0];
		secondstr2 = str[str.length - 1];
		// second apporach without use the sort we can find the smallest and lastgest elemnt in str array
		System.out.println("firststr1: " + firststr1 + " secondstr2: " + secondstr2);
		// find the prefix
		String prefix = getprefix(new String[]{firststr1, secondstr2,});
		// check the prefixsmal prefix present in whole string array
		return isprefixright(str, prefix) ? prefix : "";
	}

	public static boolean isprefixright(String[] str, String s) {
		for (int i = 0; i < str.length; i++) {
			if (!str[i].contains(s)) {
				return false;
			}
		}
		return true;
	}

	public static String getprefix(String[] str) {
		String s1 = str[0];
		String s2 = str[1];
		String prfix = "";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
			prfix += s1.charAt(i);
		}
		return prfix;
	}

	/**
	 *
	 */
	public static String longestCommonPrefix(String[] str) {
		String shortStr = "";
		int F_min = Integer.MAX_VALUE;
		// find the
		for (int i = 0; i < str.length; i++) {
			if (str[i].length() < F_min) {
				shortStr = str[i];
				F_min = shortStr.length();
			}
		}
		System.out.println("shortStr: " + shortStr);
		return getPrefixCommom(shortStr, str);
	}

	public static String getPrefixCommom(String s, String[] str) {
		int len = s.length();
		String prefix = "";
		int j;
		boolean ispresent = false;
		for (j = 0; j < len; j++) {
			for (int i = 0; i < str.length; i++) {
				if (str[i].charAt(j) != s.charAt(j)) {
					ispresent = false;
					break;
				}
				ispresent = true;
			}
			if (ispresent) {
				prefix += s.charAt(j);
			}
		}
		System.out.println("prefix: " + prefix);
		return isprefixright(str, prefix) ? prefix : "";
	}




	//////////////////////////////////////////////////////////////////
	/**
	 *1- first we take the 2 pointer first, second store the Integer.Min
	 * 2- itrate the loop for array
	 * 3- if the curre > first upate the second with first and first with current
	 * 4- again in the if we check current > second and current != first
	 * 5- update the second with current
	 */

//	public static void firstSecondLargest( int [] arr){
//		int first = Integer.MIN_VALUE;
//		int second = Integer.MIN_VALUE;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] < first) {
//				second = first;
//				first = arr[i];
//			} else if (arr[i] > second && arr[i] != first) {
//				second = arr[i];
//			}
//		}
//	System.out.println( "first: " + first+" second: " + second);
//	}


	/**
	 * 1- find the first and second smallest element in array
	 * 2- take the 2 pointer first, second with Integer.MAX_VALUE
	 * 3- itrate the array and check
	 * 4- if current < then the first then second = first and first = current
	 * 5- again check if the current is < the second and current!=first
	 * 6- store the second=current
	 */

//	public  static void firstANDSecondSmallest( int []arr){
//
//		int first = Integer.MAX_VALUE;
//		int second = Integer.MAX_VALUE;
//		for (int i = 0; i < arr.length; i++){
//			if (arr[i] < first){
//				second = first;
//                first = arr[i];
//			}else if(arr[i] < second&& arr[i]!=first){
//				second = arr[i];
//			}
//		}
//		System.out.println("first: " + first+" second: " + second);
//	}
}
