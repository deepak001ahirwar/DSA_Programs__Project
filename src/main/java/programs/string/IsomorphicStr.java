package programs.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IsomorphicStr {
    public static void main(String[] args) {
//
//        If the characters in str1 can be changed to get str2, then two strings,
//        str1 and str2, are isomorphic.
//        Input:
//        str1 = aab
//        str2 = xxy
//        Output:
//        1
//        Explanation:
//        There are two different characters in aab and xxy, i.e a and b
//        with frequency 2 and 1 respectively.
        System.out.println(isIsomorphic("aab", "xyz")); // Output: 1
        System.out.println(OptimizedisIsomorphic("aab", "xxz")); // Output:
    }
    /**
     * 1- in the place of use the array that store the ascii value of char
     * 2- logic is  same
     */
    private static boolean OptimizedisIsomorphic(String S, String T) {
        int[] A = new int[128];
        int[] B = new int[128];
        Arrays.fill(A, -1);
        Arrays.fill(B, -1);
        StringBuffer buffS = new StringBuffer(S);
        StringBuffer buffT = new StringBuffer(T);
        for (int i = 0; i < S.length(); i++) {
            char s1 = buffS.charAt(i);
            char s2 = buffT.charAt(i);
            if (A[s1] == -1) {
                A[s1] = s2;
            }
            if (B[s2] == -1) {
                B[s2] = s1;
            }
            if (A[s1] != s2 || B[s2] != s1) {
                return false;
            }
        }
        return true;
    }
    /**
     * 1- take the 2 map for storing the char to be repaled char
     * 2- itrate the both str char by char if not exits  s1 as key and s2 as value in map1
     * 3- same not exits s2 as key and s1 as value
     * 4- if extits then check the map1 key s1  the value is not equal to s2
     * 5- same as map2 s2 key the value is not equal to s1 return false
     * 6- return true
     */
    private static boolean isIsomorphic(String S, String T) {
        Map<Character, Character> StoTMap = new HashMap<Character, Character>();
        Map<Character, Character> TtoSMap = new HashMap<Character, Character>();
        StringBuffer buffS = new StringBuffer(S);
        StringBuffer buffT = new StringBuffer(T);
        for (int i = 0; i < S.length(); i++) {
            char s1 = buffS.charAt(i);
            char s2 = buffT.charAt(i);
            if (!StoTMap.containsKey(s1)) {
                StoTMap.put(s1, s2);
            }
            if (!TtoSMap.containsKey(s2)) {
                TtoSMap.put(s2, s1);
            }
            if (StoTMap.get(s1) != s2 || TtoSMap.get(s2) != s1) {
                return false;
            }
        }
        return true;
    }


    // Not the good Apporach
//    private static int isIsomorphic(String s1, String s2) {
//        Set<Character> set1 = new HashSet<Character>();
//        Set<Character> set2 = new HashSet<Character>();
//        if (s1.length()!=s2.length()){
//            return 0;
//        }
//        for (char c : s1.toCharArray()) {
//            set1.add(c);
//        }
//        for (char c : s2.toCharArray()) {
//            set2.add(c);
//        }
//        if (set1.size() == set2.size()) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
}
