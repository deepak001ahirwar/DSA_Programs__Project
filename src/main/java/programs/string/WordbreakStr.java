package programs.string;

import java.util.ArrayList;
import java.util.List;

public class WordbreakStr {
    public static void main(String[] args) {
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
        /*** use the resussion to solved the problem*/
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        String str = "leetcode";
        System.out.println(wordBreak(str, "", wordDict));
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
}
