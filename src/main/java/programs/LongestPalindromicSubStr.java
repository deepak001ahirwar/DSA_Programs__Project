package programs;

import java.util.List;

public class LongestPalindromicSubStr {

    public   int start =0,end=0,maxLength=1;

    public static void main(String[] args) {


//		Given a string s, return the longest 
//		palindromic substring
//		 in s.


//		Input: s = "babad"
//				Output: "bab"
//				Explanation: "aba" is also a valid answer.


        /**Approach-1
         *1- find all the substr from sliding window and recursion
         *2- pass these substr to palidrone function to check
         *3- str is plindrone
         */

        String str = "babad";

        System.out.println("OriginalStr: " + str);

//        List<String> list = new ArrayList<>();
//        System.out.println("getsubstr: " + getsubstr(0, str.length(), str, list, ""));
//        System.out.println("strArr: " + list.toString());


        // 2- second apporach
        /**
         * 1- find out the substr of the string
         * 2- check if the sub Str is palindrome then store the length into maxlen ,
         * 3- also store the start and end index
         * 4- return the substring of start , end+1
         *
         *
         */

//        System.out.println("longestPalindronSubString: "+longestPalindronSubString(str) );
        /** 3- optimal apporach loop iteration
         *
         * 1- for odd num itrate the outer loop for  wholeStr
         * 2- take 2 pointer start=0, end=0, MaxLength=1
         * 3- take other 2 pointer l=i, r=i
         * 4- in the while loop untill l>=0 && r< n
         * 5- inside the while loop  if str[l]==str[r]
         * 6- l--, r++ else  break the inner loop
         * 7- calculate the len =r-l-1; the check if len>MaxLength
         * 8- then update the MaxLength with len , start=L+1, end=r-1;
         * 9- same thing with  Even Number
         * 10- al the end substr of (start, end +1)
         * */
        LongestPalindromicSubStr subStr = new LongestPalindromicSubStr();

        System.out.println("optimalSubStr: " + subStr.optimalSubStr(str));

    }

    public String optimalSubStr(String str) {
        if (str.length() <= 1) return str;
        int n = str.length();
        for (int i = 0; i < str.length() - 1; i++) {
            getAcutalPalindrone(str,i,i);
            getAcutalPalindrone(str,i,i+1);
        }
        return str.substring(start, end + 1);
    }

    public  void getAcutalPalindrone(String str, int l, int r) {
            while (l >= 0 && r < str.length()) {
                if (str.charAt(l) == str.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            int len = r - l - 1;
            if (len > maxLength) {
                maxLength = len;
                start = l + 1;
                end = r - 1;
            }

    }

    public static String longestPalindronSubString(String str) {
        int maxLen = 0, start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                // check palindrome
                if (ispalindroneUpdated(str, i, j)) {
                    // check the maximum length palindrome
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return str.substring(start, end + 1);
    }

    private static boolean ispalindroneUpdated(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static String getsubstr(int startindex, int len, String s, List<String> list, String pstr) {
//		String strArr[]= new String[len];
//		String pstr= new String();
        String tempStr = String.valueOf(s.charAt(startindex));
        list.add(tempStr);
        if (ispalindrone(tempStr)) {
            if (tempStr.length() > pstr.length()) {
                pstr = tempStr;
            }
        }
//		strArr[startindex]=tempStr;
        for (int i = startindex + 1; i < len; i++) {
            tempStr = tempStr + String.valueOf(s.charAt(i));
            list.add(tempStr);
            System.out.println("tempStr: " + tempStr);
            if (ispalindrone(tempStr)) {
                if (tempStr.length() > pstr.length()) {
                    pstr = tempStr;
                }
            }
        }
        startindex++;
        // calling recursion
        if (startindex < len) {
            pstr = getsubstr(startindex, len, s, list, pstr);
        }
        return pstr;
    }

    public static boolean ispalindrone(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
