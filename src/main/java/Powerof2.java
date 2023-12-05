
public class Powerof2 {

	public static void main(String[] args) {

				/*Input: n = 16
				Output: true
				Explanation: 24 = 16
				
				Input: n = 3
				Output: false*/
		
		// Apprach-1
		/*1- diveide the number until got the 1 or any odd 
		 * if got 1 return true or got the odd number 
		 * return false
		 */
	
		// Apprach -2
		// use bit manipulation & or (n&n-1)==0
		
		int num=16;
		
		System.out.println("num: "+num);
		
		System.out.println(ispowerof2(num));
		
		
		System.out.println(12^10);
		
	}
	
	
	public static boolean ispowerof2(int num) {

		// first not working 
//		while (num > 1) {
//			num = num / 2;
//			if (num == 1) {
//				return true;
//			}
//			if (num % 2 != 0) {
//				return false;
//			}
//		}
//		return false;
		
		
		// second apporach-2
		
		System.out.println(num&num-1);
		if((num&num-1)==0) {			
			return true;
		}
		return false;

	}

}
