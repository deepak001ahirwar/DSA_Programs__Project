package programs.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumber {
    public static void main(String[] args) {
//        Input:
//        s = V
//        Output: 5

        /* 1- convert roman number into Integer
         * 2- first take the map in to store the all the given roman and integer store
         * 3- itrate the string and compare the currentCharAt(i) integre value with nextChar(i+1)
         * 4- if the i+1 value is greather then subtract the from total -= currentCharAt(i) ( integer value)
         * 5- else add the  total + = currentCharAt(i)
         * 6- the base condtion also the i+1< str.length
         */
        String roman = "IV";
        System.out.println("romanToInteger : " + romanToInteger(roman));
    }
    public static Map<Character, Integer> romanMap = new LinkedHashMap<>();
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }
    public  static int romanToInteger(String str) {
        int total = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int current = romanMap.get(str.charAt(i));
            if (i + 1 < len && romanMap.get(str.charAt(i + 1)) > current) {
                total -= current;
            } else {
                total += current;
            }
        }
        return total;
    }
}
