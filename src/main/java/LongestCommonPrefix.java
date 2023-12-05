import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] strs = { "flower", "flow", "flight" };

		System.out.println("strs: " + Arrays.toString(strs));
//		System.out.println("longestCommonPrefix: " + longestCommonPrefix(strs));

		
		
		
		
//		String s = stirs[0];
//		for (int i = 1; i < strs.length; i++) {
//			while (strs[i].indexOf(s) != 0) {
//				s = s.substring(0, s.length() - 1);
//
//			}
//	       }
		System.out.println(longestCommonPrefix2(strs));

	}

	public static String longestCommonPrefix2(String[] str) {

		// first find the smallest and secondsmalest
		String firststr1 = "";
		String secondstr2 = "";
		Arrays.sort(str);
		firststr1=str[0];
		secondstr2=str[str.length-1];
//		int F_min = Integer.MAX_VALUE;
//		int S_min = Integer.MAX_VALUE;
//
//		for (int i = 0; i < str.length; i++) {
//			// smalest
//			if (str[i].length() < F_min) {
//				secondstr2 = firststr1;
//				S_min = secondstr2.length();
//				firststr1 = str[i];
//				F_min = firststr1.length();
//			}
//			// second small
//			if (str[i].length() != F_min && str[i].length() < S_min) {
//				secondstr2 = firststr1;
//				S_min = secondstr2.length();
//
//			}
//		}
		System.out.println("firststr1: " + firststr1 + " secondstr2: " + secondstr2);
		// find the prefix
		String prefix = getprefix(new String[] { firststr1, secondstr2, });
		// check the prefixsmal prefix present in whole string array
		return isprefixright(str, prefix) ? prefix : prefix;
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
		System.out.println("shortStr: "+shortStr);
		return getPrefixCommom(shortStr, str);
	}

	public static String getPrefixCommom(String s, String[] str) {

		int len = s.length();
		String prefix = "";
		int j;
		boolean ispresent=false;
		for ( j=0; j < len; j++) {
			for (int i = 0; i < str.length; i++) {
				if (str[i].charAt(j)!= s.charAt(j)) {
					ispresent=false;
					break;
				}
				ispresent=true;
			}
			if(ispresent) {
				prefix+=s.charAt(j);
			}
		}
//		prefix=s.substring(j);
		System.out.println("prefix: " + prefix);
		return isprefixright(str, prefix) ? prefix : "";
	}

}
