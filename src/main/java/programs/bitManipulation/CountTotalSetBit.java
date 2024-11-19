package programs.bitManipulation;

public class CountTotalSetBit {
    public static void main(String[] args) {
//        Count total set bits
//        You are given a number n. Find the total count of set bits for all numbers from 1 to n (both inclusive).
//        Input: n = 4
//        Output: 5
//        Explanation: For numbers from 1 to 4. For 1: 0 0 1 = 1 set bits For 2: 0 1 0 = 1 set bits
//        For 3: 0 1 1 = 2 set bits For 4: 1 0 0 = 1 set bits Therefore, the total set bits is 5.
        int n = 4;
        System.out.println("Total set bits for numbers from 1 to " + n + " are: " + countSetBits(n));
    }

    /**
     * 1- Initialize a count variable to 0.
     * 2- Iterate from n to 0.
     * 3- In each iteration, initialize a variable x as the current number.
     * 4- While x is not 0, do the following:
     * 5- count++
     * 6- update the x with and operator of x & x-1
     */
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = n; i >= 0; i--) {
            int x = i;
            while (x != 0) {
                count++;
                x = x & (x - 1);
            }
        }
        return count;
    }

    // not corrected
    public static int countSetBitsOptimal(int n) {

        int count = 0;
        for (int i =0; i <= n; i++) {

            // for even numbers
            if (i % 2 == 0) {
                count = i / 2;
            } else {
                count = i / 2 + 1;
            }
        }
        return count;
    }
}
