package programs;
import java.util.Arrays;

public class compressionStr {

	public static void main(String[] args) {


		/*Input: chars = ["a","a","b","b","c","c","c"]
				Output: Return 6, and the first 6 characters
				 of the input array should be:
				  ["a","2","b","2","c","3"]
				Explanation: The groups are "aa", "bb", and "ccc". 
				This compresses to "a2b2c3".
				E*/
		/*
		 * Apporach-1 use the string current char and next 
		 * if current and next same the count++
		 * else store curre and count into string buffer
		 * add the last elemnt also 
		 * 
		 */
		String s="aaabbcccdddeee";
		//output a3b2c2 or length 6
		
		System.out.println("Actual Str: "+s);
		System.out.println(getcompressStr(s));
	}
	
	public static int getcompressStr(String s) {
		
		
		
		StringBuffer bf= new StringBuffer();
//		int len=s.length();
		char [] arr= {'a','b','b','b','b','b','b','b','b','b','b','b','b'};

//				s.toCharArray();
		if((arr.length==1)) {
            return arr.length;
        }
		int count=1;
		for(int i=0;i<arr.length-1;i++) {			
			if(arr[i]==arr[i+1]) {
				count++;				
			}else {
				bf.append(arr[i]);				
				if(count>1)
					{
					bf.append(count);
					}
				count=1;
			}			
		}
		bf.append(arr[arr.length-1]);
		bf.append(count);	
		System.out.println(bf.length());
		char[] newcharArr= new char[bf.length()];
		newcharArr=new String(bf).toCharArray();
		
		
		return bf.length();
		
	}

}
