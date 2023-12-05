import java.util.Arrays;

public class ReverseStringArr {

	public static void main(String[] args) {

		// 1)logic to sort an array of string manually
//		without using any inbuilt method of String class

        String[] str = {"xys","abc", "msd","acd","msabc", "lnw"};
        
        //"Xys","abc", "msd","ACD","mass", "lnw"
        /**
         * Appoarch-1
         * 1-use simple sorting 
         * 2-itrate loop and compare i j 
         * 3- compare arr[i] and arr[j]
         * 4-if arr[i]>arr[j] swap 
         * 5-simpally sorting 
         * 6 but this appaoch not good it will not run all testcases
         */

        // {"abc", "msd","mass", "lnw"}
        //  i        j
        //1- abc>msd swap 
        //       
		int len = str.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (isAgreaterB(str[i],str[j])) {
					// swap element
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(str));
		
		
		
		
		
       	
		
	}
	
	
	public static boolean isAgreaterB(String s1,String s2) {
		
		int index=0;
		int a=0,b=0;
		while (s1.length() > a && s2.length() > b) {
			if (s1.charAt(a) > s2.charAt(b)) {
				return true;
			} else if (s1.charAt(a) < s2.charAt(b)) {

				return false;
			} else {
				a++;
				b++;
			}
		}		
		if(a<s1.length()) {
			return true;
		}		
		return false;
		
	}

}
