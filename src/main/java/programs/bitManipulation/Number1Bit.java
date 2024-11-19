package programs.bitManipulation;

public class Number1Bit {
    public static void main(String[] args) {
//        Number of 1 Bits
//        Input: n = 6
//        Output: 2
//        Explanation: Binary representation is '110', so the count of the set bit is 2.
        int n = 8;
        System.out.println(setBits(n));
    }

    /**
     * 1- use the simple apporach method
     * 2- itrate the loop until the num!=0
     * 3- check num%2 is onne the count++
     * 4- update the num = num/2
     */
    public static int setBits(int n) {
        int Count = 0;
        while (n != 0) {
            int i = n % 2;
            if (i == 1) {
                Count++;
            }
            n = n / 2;
        }
        return Count;
    }

    /**
     * 2- use the & operator
     * 1- itrate the while loop untill the n!=0
     * 2- count++ and update the num = num & num-1
     */
    public static int setBitsAlternative(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
