package programs.string;

import java.util.HashMap;

public class TransformString {

    public static void main(String[] args) {
//        Input:
//        A = "abd"
//        B = "bad"
//        Output: 1
//        Explanation: The conversion can take place in
//        1 operation: Pick 'b' and place it at the front.
        String A = "cd";
        String B = "ce";
        System.out.println(transformString(A, B));
    }
    /**
     * 1- use the 2 pointer apporach from both the str
     * 2- first check the if both str os not equal and not the same char the return -1
     * 3- itrate the both str from last index and check if match the both str char then i--,j--
     * 4- else count++ and i--
     * 5- at the end return count
     */

    private static int transformString(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        // sum of all char ascii A and B is equal or not
//        int sumA = 0, sumB = 0;
//        for (int i = 0; i < A.length(); i++) {
//            sumA += A.charAt(i);
//            sumB += B.charAt(i);
//        }
//        if(sumA!= sumB){
//            return -1;
//        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            hm.put(A.charAt(i), hm.getOrDefault(A.charAt(i), 0) + 1);
            hm.put(B.charAt(i), hm.getOrDefault(B.charAt(i), 0) - 1);
        }
        for (int c : hm.values()) {
            if (c != 0) return -1;
        }
        int i = A.length() - 1, j = B.length() - 1, Count = 0;
        while (i >= 0 && j >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                i--;
                j--;
            } else {
                Count++;
                i--;
            }
        }
        return Count;
    }
    // Not good apporach
//    private static int transformString(String a, String b) {
//        int Count = 1;
////        for (int i = 1; i < a.length(); i++) {
////            String swapStr = swap(a, 0, i);
////            if (swapStr.equals(b)) {
////                return Count;
////            } else {
////                Count++;
////            }
////        }
////        return Count;
//    }
//    public static String swap(String str,int start, int middle) {
//        char[] charArray = str.toCharArray();
//        char temp = charArray[start];
//        charArray[start] = charArray[middle];
//        charArray[middle] = temp;
//        return new String(charArray);
//    }
}
