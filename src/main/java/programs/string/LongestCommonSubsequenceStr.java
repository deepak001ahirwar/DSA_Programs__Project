package programs.string;

public class LongestCommonSubsequenceStr {

    public static void main(String[] args) {

//        Input: text1 = "abcde", text2 = "ace"
//        Output: 3
//        Explanation: The longest common subsequence is "ace" and its length is 3.

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("text1: " + text1);
        System.out.println("text2: " + text2);
        int n = text1.length();
        int m = text2.length();
        System.out.println(" LCS: " + LCS(text1, text2, n, m));

    }

    /**
     * 1- resusive apporach
     * <p>
     * 1- find the base condtion if any str empty return ""
     * 2- choice diagram  if match the last index of s1 and s2 start remove the last element of both str
     * 3- call the resiver function 1+LCS(s1,s2,n-1,m-1)
     * 4- else  not match the element we have 2 chose either we remove the s1 last element or
     * s2 last element
     * 5- calculate the max of both and call the resiver function LCS(s1,s2,n-1,m) or LCS(s1,s2,n.m-1)
     */


    public static int LCS(String s1, String s2, int n, int m) {
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        // choice diagram
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + LCS(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(LCS(s1, s2, n - 1, m), LCS(s1, s2, n, m - 1));
        }

    }
}
