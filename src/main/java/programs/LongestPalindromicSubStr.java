package programs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubStr {

	public static void main(String[] args) {


//		Given a string s, return the longest 
//		palindromic		 
//		substring
//		 in s.
		
		
//		Input: s = "babad"
//				Output: "bab"
//				Explanation: "aba" is also a valid answer.
		
		
		/**Approach-1
		 *1- find all the substr from sliding window and recursion 
		 *2- pass these substr to palidrone function to check 
		 *3- str is plindrone  
		 */
		
		String str="ac";
		
		System.out.println("OriginalStr: "+str);
		
		List<String> list= new ArrayList<>();		
		System.out.println("getsubstr: " + getsubstr(0, str.length(), str,list,""));		
		System.out.println("strArr: "+list.toString());
		
	}
	
	
	public static String getsubstr(int startindex,int len,String s,List<String> list, String pstr) {		
//		String strArr[]= new String[len];
//		String pstr= new String();
		String tempStr=String.valueOf(s.charAt(startindex));
		list.add(tempStr);
		if(ispalindrone(tempStr)){
			if(tempStr.length()>pstr.length()){
				pstr=tempStr;
			}
		}		
//		strArr[startindex]=tempStr;
		for(int i=startindex+1;i<len;i++){			
			tempStr=tempStr+String.valueOf(s.charAt(i));
			list.add(tempStr);
			System.out.println("tempStr: "+tempStr);			
			if(ispalindrone(tempStr)){
				if(tempStr.length()>pstr.length()){
					pstr=tempStr;
				}
			}
		}				
		startindex++;		
		// calling recursion 
		if(startindex<len){
			pstr=getsubstr(startindex,len,s,list,pstr);			
		}			
		return pstr;		
	}
	public static boolean ispalindrone(String s){
		int start = 0;
		int end = s.length() - 1;
		while(start <= end){
			if (s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	
	
	

	
	
}
