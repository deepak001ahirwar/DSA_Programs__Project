
public class longestUniqueSubsttr {

	public static void main(String[] args) {

		
		String str="babad";
//				"abdefgabef";
		System.out.println("String ;"+str);
		/*String ;abdefgabef
		substr: ab
		substr: abd
		substr: abde
		substr: abdef
		substr: abdefg
		substr: bdefga
		substr: defgab
		substr: fgabe
		substr: gabef
		longestUniqueSubsttr: 6
		*/
		
		/**
		 * Apprach-1
		 * 1- use 2 loop and create the substring of string
		 * calculate the max of substring  
		 */
//		System.out.println("longestUniqueSubsttr: "+longestUniqueSubsttr(str));
		
			/***
			 * Apprahc-2 
			 * use sliding window techinique to solve the problem 
			 * 1- first store o index value in temp
			 * 2-  itarte the loop make the substring with unique char
			 * 3- i=1 to N and 
			 * 4- else then find the index of current duplcate elemnt
			 * 5- find the substring and add the current char
			 * 6- find the max length 
			 * 
			 * 
			 */
			
		System.out.println("longestUniqueSubsttr: "+longestUniqueSubsttrOptmize(str));

		
		
	}
	
	public static int longestUniqueSubsttrOptmize(String S) {
		int max = Integer.MIN_VALUE;
		String tempstr = "";
		int len = S.length();
		if (len == 1) {
			return 1;
		}
		tempstr = String.valueOf(S.charAt(0));
		for (int i = 1; i < len; i++) {
			if (!tempstr.contains(String.valueOf(S.charAt(i)))) {
				tempstr = tempstr + String.valueOf(S.charAt(i));
			} else {
				int index = tempstr.indexOf(String.valueOf(S.charAt(i)));
				String substr = tempstr.substring(index + 1);
				tempstr = "";
				tempstr = substr + String.valueOf(S.charAt(i));
			}
			System.out.println("substr: " + tempstr);
			max = Math.max(max, tempstr.length());

		}
		return max;
	}
	

	public static int longestUniqueSubsttr(String S) {

		int max = Integer.MIN_VALUE;
		String tempstr = "";
		int len = S.length();
//         tempstr=String.valueOf(S.charAt(0));
		for (int i = 0; i < len ; i++) {
			tempstr = "";
			tempstr = String.valueOf(S.charAt(i));
			for (int j = i + 1; j < len; j++) {
				if (!tempstr.contains(String.valueOf(S.charAt(j)))) {
					tempstr = tempstr + S.charAt(j);
				}
			}
			System.out.println("tempstr: " + tempstr);
			max = Math.max(max, tempstr.length());

		}
		System.out.println("max: " + max);
		return max;
	}

}
