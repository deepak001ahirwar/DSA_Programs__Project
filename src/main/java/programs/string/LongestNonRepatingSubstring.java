package programs.string;

import java.util.HashMap;

public class LongestNonRepatingSubstring {


    public static void main(String[] args) {


//        Output for Input: "pwwkew"
//        Length: 3 (Substring: "wke").

        String str = "abdefgabef";
        System.out.println("Input: " + str);
        System.out.println("Length: " + lengthOfLongestSubstring(str));

    }

    /**
     * 1- first use the sliding
     *
     */

    private static String lengthOfLongestSubstring(String str) {

        if(str==""||str.isEmpty()){
            return "Input String is Empty";
        }

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int maxLen = 0;
        int longestStart=0;
        int start = 0;
        for(int end =0; end < str.length(); end++){

            char ch = str.charAt(end);
            // if present then update the start
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch)+1);
            }

            // update the maxLen and map
            map.put(ch, end);
            // Update the longest substring if a longer one is found
            int w_Length = end-start+1;
            if(w_Length>maxLen){
                maxLen = w_Length;
                longestStart = start;
            }
        }
        System.out.println("longestStart: "+longestStart+" "+ "maxLen: "+maxLen);
        return str.substring(longestStart, longestStart + maxLen);
    }
}
