package programs.string;

import java.util.Stack;

public class DecodeStrProg {

    public static void main(String[] args) {

//		String strArr1[]=str.split("]");
//		System.out.println(strArr1.toString());
//		String  newString=null;
//		for(String s1:strArr1) {			
//			if(s1.contains("[")){
//				String strArr2[]=s1.split("[");
//				int count =Integer.parseInt(strArr2[0]);
//				String s2=strArr2[1];
//				if(count>0) {
//					newString=newString+s2;
//					count--;
//				}				
//			}else {
//				newString=newString+s1;
//			}
//		}
//		System.out.println(newString);
        String s = "3[a]2[bc]";
        /***   Apporch -1
         1- take 2 stack numStack and ssStack
         2- put the num in numstack and all data on ssStack untill ] comes
         3- when ] in loop pop the tempstr  ssstack and  count from numstack
         4- make the str pop [ and push str tp ssstack
         */
        // first apporach did not run all cases
//		 	Stack<Integer> numstack = new  Stack<Integer>();
//		 	Stack<String> ssstack = new  Stack<String>();
//		 	int count=0;
//		 	String tempstr= new String();
//		 	for(char ch:s.toCharArray()) {		
//		 		// itstore num into numstack
//		 		if(ch>='0'&&ch<='9') {
//		 			count=ch-'0';
//		 			numstack.push(count);			
//		 		}
//		 		// store [ and char 
//		 		else if(ch!=']') {
//		 			tempstr=Character.toString(ch);
//		 			ssstack.push(tempstr);
//		 		}
//		 		//pop and make the encode str
//		 		else if(ch==']') {
//		 			tempstr=new String();
//		 			String str2= new String();
//		 			int numcount=numstack.pop();
//		 			String startbrack=Character.toString('[');
//		 			while(!(ssstack.peek().equals(startbrack))) {
//		 				str2=ssstack.pop()+str2;	
//		 			}
//		 			while(numcount>0) {
//		 				tempstr=tempstr+str2;
//		 				numcount--;
//		 			}
//		 		// for [
//		 		ssstack.pop();		
//		 		ssstack.push(tempstr);		
//		 		}
//		 	}		
//		 	String finalEncodedStr=new String();		
//		 	while(!ssstack.isEmpty()) {
//		 		finalEncodedStr=ssstack.pop()+finalEncodedStr;
//		 	}
//		 return finalEncodedStr;
        // 2 -second appoch run all test cases
        Stack<Integer> numstack = new Stack<Integer>();
        Stack<StringBuffer> ssstack = new Stack<StringBuffer>();
        int count = 0;
        StringBuffer str = new StringBuffer();
        for (char ch : s.toCharArray()) {
            // itstore num into numstack
            if (ch >= '0' && ch <= '9') {
                count = (count * 10) + ch - '0';
//					numstack.push(count);
            }
            // store [ and char
            else if (ch == '[') {
                ssstack.push(str);
                str = new StringBuffer();
                numstack.push(count);
                count = 0;
            }
            //pop and make the encode str
            else if (ch == ']') {
                StringBuffer tempstr = str;
                str = ssstack.pop();
                int numcount = numstack.pop();
                while (numcount > 0) {
                    str.append(tempstr);
                    numcount--;
                }
            } else {
                str.append(ch);
            }
        }
        System.out.println("Final Str: " + str);
//				return new String(str);
    }
}

