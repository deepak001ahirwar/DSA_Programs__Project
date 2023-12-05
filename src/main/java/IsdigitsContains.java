
public class IsdigitsContains {

	public static void main(String[] args) {

//		How to check if string contains only digits in Java
		/*
		 * Input: str = “1234” 
		 * Output: true Explanation: 
		 * The given string contains only
		 * digits so that output is true
		 * . Input: str = “GeeksforGeeks2020” 
		 * Output: false
		 * Explanation: The given string contains alphabet character
		 *  and digits so that
		 * output is false.
		 */
		
		/**
		 * Apprach-1
		 * 1- use the ascii value and charAt(i)-'0' and
		 * 2- it will lies between 0 to 9 the true otherwise false
		 * 
		 */

		String str = "GeeksforGeeks2020";
		System.out.println("str: "+str);
		System.out.println("isdigitsConatins: "+isdigitsConatins(str));

	}

	public static boolean isdigitsConatins(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (!(str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)) {
				return false;
			}
		}
		return true;
	}
}
