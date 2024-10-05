package programs.string;


import org.graalvm.collections.Pair;

import java.util.Arrays;

public class RearrangeCharacters {

    public static void main(String[] args) {

        //Input : str = "geeksforgeeks"
//        Output: 1 or (ekekeoerfsgsg)
//        Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//        Return any possible rearrangement of s or return "" if not possible.
        String str = "geeksforgeeks";
        System.out.println("str = " + str);
        System.out.println("rearrangeString: " + rearrangeString(str));
    }

    /**
     * 1- make the frequency array and store the frequency in that character
     * 2- find the max frequency char and max_value
     * 3- check if the max frequency is greater than (N+1)/2 then return 0 ("")
     * 4- create the empty str "" with  N length like places where we store the elements
     * 5- fill the max frequency char in to even places and make frequency of that char 0
     * 6-now fill the other char frequency and first ,now filling the other Chars, first filling the
     * even positions and then the odd positions
     * 7- reduce the frequency as well
     * 8- at the end return result or 1
     */
    private static String rearrangeString(String str) {
        int[] freq = new int[26];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            freq[str.charAt(i) - 'a']++;
        }
        System.out.println("freq Array " + Arrays.toString(freq));
        Pair<Character, Integer> max_charPair = maxFrequency(freq);
        char maxChar = max_charPair.getLeft();
        int maxCount = max_charPair.getRight();
        System.out.println("maxChar " + maxChar + " maxCount " + maxCount);
        if (maxCount > (n + 1) / 2) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append(" ".repeat(n));
        // fill the max characters in the result index+2 because at even index
        int ind = 0;
        while (maxCount > 0) {
            result = new StringBuilder(result.substring(0, ind) + maxChar
                    + result.substring(ind + 1));
            ind += 2;
            maxCount--;
        }
        freq[maxChar - 'a'] = 0;
        System.out.println("freq Array " + Arrays.toString(freq));
        // fill the other characters at even places and odd places
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ind = (ind >= n) ? 1 : ind;
                result = new StringBuilder(result.substring(0, ind) + (char) ('a' + i)
                        + result.substring(ind + 1));
                ind += 2;
                freq[i]--;
            }
        }
//        return new String(result);
        return "1";
    }

    public static Pair<Character, Integer> maxFrequency(int[] freq) {
        int max = Integer.MIN_VALUE;
        char maxChar = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxChar = (char) ('a' + i);
            }
        }
        return Pair.create(maxChar, max);
    }


}
