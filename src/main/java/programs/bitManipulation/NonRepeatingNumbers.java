package programs.bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRepeatingNumbers {
    public static void main(String[] args) {

//        Input: arr[] = [1, 2, 3, 2, 1, 4]
//        Output: [3, 4]
//        Explanation: 3 and 4 occur exactly once.
    }

    /**
     * 1- & Operator
     *  when both 1 then return 1 otherwise 0
     *  2- | Operator :
     *   when anyone is 1 then return  1 otherwise zero
     *  3- xor ^ Operator:
     *  when both same then return zero otherwise 1
     */
    /**
     * A- using the map
     * 1- now we have to use the  bit manipulation
     * 2- use the XOR or all elemnt
     * 3- find the rightmostset Bit xor & ~ xor
     * 4- Divide the number into 2 groups and Xor within each Group
     * 5- itrate the loop untill
     *  6- if the num& rightmostBit ==0 , num1= num1^ num // bit of zero
     *  7- else case num2 =num2^num
     */
    public List<Integer> singleNumber(int[] arr) {

        int xor = 0;
        // XOR all elements

        for (int num : arr) {
            xor ^= num;
        }
        // Find the rightmost set bit
        int rightmostBit = xor & (~xor + 1);

        int num1 = 0;
        int num2 = 0;
        // Divide numbers into two groups and XOR within each group

        for (int num : arr) {
            if ((num & rightmostBit) == 0) {
                num1 ^= num;  // // Group 1: Bit is 0
            } else {
                num2 ^= num;// Group 2: Bit is 1
            }
        }
        int nums[] = new int[]{num1, num2};
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        for (int ls : nums) {
            result.add(ls);
        }
        return result;
    }
}
