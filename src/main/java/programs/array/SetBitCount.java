package programs.array;
import com.sun.tools.javac.Main;
import java.util.Arrays;
import java.util.Comparator;

public class SetBitCount {

    public static void main(String[] args) {
        //  Sort by Set Bit Count
//        nput:
//        arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
//        Output:
//        15 7 5 3 9 6 2 4 32
//        Explanation:
//        The integers in their binary
//        representation are:
//        15 - 1111
//        7  - 0111
//        5  - 0101
//        3  - 0011
//        9  - 1001
//        6  - 0110
//        2  - 0010
//        4  - 0100
//        32 - 10000
//        hence the non-increasing sorted order is:
//        {15}, {7}, {5, 3, 9, 6}, {2, 4, 32}

        Integer  arr[] ={5, 2, 3, 9, 4, 6, 7, 15, 32};
        sortArrayBySetBitCount(arr);

    }

    private static void sortArrayBySetBitCount(Integer[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int bitCount = countSetBits(arr[i]);
            System.out.println(arr[i] + "  => " + bitCount);
        }
//            Arrays.sort(arr, Comparator.comparingInt( Main:: countSetBits ).reversed().thenComparingInt(a->a));
    }

    /**
     * it will return the number of 1 bit in the number
     *
     */
    private static int countSetBits(int n) {
        int count = 0;
        while (n!= 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
        //  return Integer.bitCount(n)
    }
}
