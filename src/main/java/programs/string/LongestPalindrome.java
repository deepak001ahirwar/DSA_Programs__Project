package programs.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(" Str: "+str);
        System.out.println("Longest Palindromic length: " + longestPalindrome(str));
    }


    /**
     * 1- use the Map that store the frequency of every element
     * 2- itrate the loop of frequency
     * 3- if the value is even then res=res+freq;
     * 4- else res=res+freq-1 also maniatn the isodd variable that at the end we identify if any
     * 5- res has odd number then we add the res=res+1
     */
    private static int longestPalindrome(String str) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char ch[] = str.toCharArray();
        for (char chr : str.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }
        int res = 0;
        boolean isOdd = false;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                res += value;
            } else {
                res += value - 1;
                isOdd = true;
            }
        }
        if (isOdd) {
            res += 1;  // for odd length palindromes
        }

        return res;
    }
}
