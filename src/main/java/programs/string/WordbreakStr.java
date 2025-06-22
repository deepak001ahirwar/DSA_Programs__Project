package programs.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordbreakStr {
    public static void main(String[] args) {
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
        /*** use the resussion to solved the problem*/
        List<String> wordDict = new ArrayList<String>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        String str = "leetcode";
//        System.out.println(wordBreak(str, "", wordDict));

        wordDict.add("i");
        wordDict.add("like");
        wordDict.add("gfg");
        String str = "ilike";

        String [] list = {"i","like"};
        Arrays.asList(list);

        System.out.println(optimalWordBreak(str,wordDict));
    }

    public static boolean wordBreak(String s, String ans, List<String> wordDict) {
        if (s.isEmpty()) {
            System.out.println("wordBreak: " + ans);
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()),
                        ans + (ans.isEmpty() ? word : " " + word), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }


    //

    /**
     *1- use the DP to solve the problem
     * 2- use the hasSet to store the dictionary to handle the duplicate element
     * 3- use the dp boolean array of size+1 of inputstr
     * 4- for base case store dp[0]=true
     * 5- use the two loop first one is itrate the inputstr from index=1 to <=len
     * 6- inner loop start from j=0 to j<i
     * 7- check if dp[j] && str.subStr(j,i) is contains dictionary then update
     *  the dp[i] = true comes from the inner loop break
     *  8- for all substring check if the contains in dictionary
     *  9- at the end return the last index value of dp array
     */

    public static boolean optimalWordBreak(String str,List<String> dictionary){
        Set<String> wordDict = new HashSet<>(dictionary);
        int len= str.length();
        boolean [] dp = new boolean[len+1];
        // base case
        dp[0]=true;
        // itrate the inputstr
        for(int i=1;i<=len;i++) {
//            for(int j=0;j<i;j++){
//                String substr = str.substring(j,i);
//                if(dp[j]&&wordDict.contains(substr)){
//                    dp[i]=true;
//                    break;
//                }
//            }

            // another way

            for (String w : dictionary) {
                // Check if the current word is present and
                // the prefix before the word is also
                // breakable
                int start = i - w.length();
                if (start >= 0 && dp[start]
                        && str.substring(start,
                                start + w.length())
                        .equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


}
