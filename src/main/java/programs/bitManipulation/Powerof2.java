package programs.bitManipulation;

public class Powerof2 {

    public static void main(String[] args) {

				/**Input: n = 16
				Output: true
				Explanation: 24 = 16
				Input: n = 3
				Output: false*/
        // Apprach-1
        /**1- diveide the number until got the 1 or any odd
         * if got 1 return true or got the odd number
         * return false
         */
        // Apprach -2
        // use bit manipulation & or (n&n-1)==0
        int num = 16;
		System.out.println("num: " + num);
        System.out.println(ispowerof2(num));
        System.out.println(12 ^ 10);
    }

	/**
	 *1-  check if the number & num-1 ==0 then its power of true
	 * 2- Time complecity id O(log n)
	 */
    public static boolean ispowerof2(int num) {
		// first not working
		// second apporach-2
		System.out.println(num & num - 1);
		if ((num & num - 1) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 1- first the cal the number of 1 of binary represention of number
	 * 2- if count 1 true otherwise false
	 * O(N)
	 */
	public static boolean ispowerof(int num) {
		int count =0;
		while(num!=0){
			count++;
			num = num&(num-1);
		}
		return count == 1;
	}

	}
