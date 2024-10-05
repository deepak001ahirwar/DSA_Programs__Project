package programs.string;

import java.util.HashSet;

public class SmallestDistinctWindow {
    public static void main(String[] args) {

//        Input: "AABBBCBBAC"
//        Output: 3
//        Explanation: Sub-string -> "BAC"
        String str = "AABBBCBBAC";
        System.out.println("str: " + str);
        System.out.println("SmallestDistinctWindow: " + getSmallestDistinctWindow(str));
    }

    /**
     * A - Apporach  to use the hashSet
     * 1- first take the hashSet and store all the elements in that so got the unique elements
     * 2- take pointer start=0,startIndex=0, counter=0,min_len=Integer.MAX_VALUE and
     * also required the vistedArr for 256 characters
     * 3- itrate the str and inside the loop
     * 4- if the vistedArr[star.chatAt(i)-65]++ it means store the frequncey
     * 5- check if the vistedArr[star.chatAt(i)-65] comes first time then counter++
     * 6- check if the counter == size of unique elements the syn logic start
     * 7- inside the while loop check vistedArr[star.chatAt(start)-65] >1 then
     * 8- vistedArr[star.chatAt(start)-65]-- and start++
     * 9- outside the while loop check curr_len= i+start+1 and check if min_len> curr_len
     * 10- update the min_len=curr_len and startIndex=start
     * 11- at the end calculate the substring ( startIndex,startIndex+min_len)
     */
    private static String getSmallestDistinctWindow(String str) {
        int size = str.length();
        HashSet<Character> set = new HashSet<Character>();
        int[] vistedArr = new int[256];
        int counter = 0, start = 0, min_len = Integer.MAX_VALUE, startIndex = 0;
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        System.out.println("uniqueElements: " + set);
        int uniqueElements = set.size();
        for (int i = 0; i < size; i++) {
            int index = str.charAt(i) - 65;
//            vistedArr[index] = vistedArr[index] + 1;
            vistedArr[index]++;
            // first time for character

            if (vistedArr[index] == 1) {
                counter++;
            }
            // check if all unique elements are visited
            //window syn logic
            if (counter == uniqueElements) {
                while (vistedArr[str.charAt(start) - 65] > 1) {
                    if (vistedArr[str.charAt(start) - 65] > 1) {
                        vistedArr[str.charAt(start) - 65]--;
                        start++;
                    }
                }
                int curr_len = i - start + 1;
                if (curr_len < min_len) {
                    min_len = curr_len;
                    startIndex = start;
                }
            }
        }
        System.out.println("start:" + start + " startIndex: " + startIndex + " min_len: " + min_len);
        return str.substring(startIndex, startIndex + min_len);
    }
}
