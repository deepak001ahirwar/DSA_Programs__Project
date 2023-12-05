
public class ValidPalindromeII {

	public static void main(String[] args) {

		
		String str="abecbea";
		//abecbea
		/* Given a string s, return true if the s can be palindrome
		 *  after deleting at most one character from it.
			it will return true or false;
		 * Input  : str = “abcba”
				Output : Yes
				we can remove character ‘c’ to make string palindrome
				Input  : str = “abcbea”
				Output : Yes
				we can remove character ‘e’ to make string palindrome
				*/
		// Apporach-1
		//use 2 pointer apporach for 
	    // internal also check if remove the the left+1 or right-1
		
		// logic- if s.charAt(left) and s.charAt(right) is not same then
		// need to check which element need to be delete left or right 
		// for that we check the left+1 to right is palindrone
		// or we also check the left to right-1 is palindrone 
		
		
		//
		System.out.println("Str: "+str);				
		System.out.println("validPalindromeStr: "+validPalindromeStr(str));				

		System.out.println(false||true);
		System.out.println(true||false);
		
	}
	
	public static boolean validPalindromeStr(String s) {
		int len = s.length();
		int left = 0;
		int right = len - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
			left++;
			right--;
		}
		return true;
	}
	
	

	
	public static boolean isPalindrome(String s, int start, int end) {
		while(start<=end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
	
		}
		return true;
	}
	
	
	
	

}
