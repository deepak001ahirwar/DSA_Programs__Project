package programs.bitManipulation;


public class FindPositionSetBit {
    public static void main(String[] args) {
//        Find position of set bit
//        nput:
//        N = 2
//        Output:
//        2
//        Explanation:
//        2 is represented as "10" in Binary.
//        As we see there's only one set bit
//        and it's in Position 2 and thus the
//        Output 2.
    }

    /**
     * 1- base case if the N==0 or not the power of 2 return -1
     * 2- take the position=1
     * 3- iterate the while loop until the least significant bit is once by n&1 ==0
     * 4- right shift >> 1 update the num
     * 5- position++
     */
    public static int findPosition(int N) {
        if (N == 0 || (N & N - 1) != 0) return -1;

        int position = 1;// Position starts at 1 (1-based indexing)
        while ((N & 1) == 0) { // Check if the least significant bit is 0
            N = N >> 1;// Right shift n by 1
            position++;
        }
        return position;
    }

    /**
     * 2- Optimal used the logs
     * 3-
     */
    public static int findPositionOptimal(int N) {

        if (N == 0 || (N & (N - 1)) != 0) {
            return -1; // Invalid case
        }
        return (int)(Math.log(N) / Math.log(2)) + 1; // Use log base 2
    }
}