package programs.string;

import java.util.ArrayList;
import java.util.List;

public class CountPalindromeSubsequnce {

    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {

        /**
         * 1- first calculate the subsequence
         * 2- and check if the subsequence is plaindrome count++;
         * 3- at the end return count
         */
        String str = "aab";
        System.out.println(" Str: " + str);
        System.out.println("countPalindromeSubsequences:  " + countPalindromeSubsequences(str));
    }

    public static int countPalindromeSubsequences(String s) {
        int n = s.length();
        int count = 0;
        findSubsequences(s, "");
        for (String ls : list) {
            if (!ls.equals("") && isPalindrome(ls, 0, ls.length() - 1)) {
                System.out.println(ls);
                count++;
            }
        }
        return count;
    }

    public static void findSubsequences(String s, String curr) {
        if (s.length() == 0) {
            list.add(curr);
            return;
        }
        // first char with next character
        findSubsequences(s.substring(1), curr + s.charAt(0));
        // first char with current character
        findSubsequences(s.substring(1), curr);
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
