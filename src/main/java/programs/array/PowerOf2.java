package programs.array;

public class PowerOf2 {

    public static void main(String[] args) {

//        I have to check the number is power of 2 or not
//        Ex - 16
//        Out - true
//        Ex- 15
//        Op- false;

        int num = 16;
        System.out.println(isPowerOfTwo(num));

    }

    /**
     * 4 & 5 power of 2 or not
     *  * 100 & 11  = 000  return true
     *          * for 5
     *          * 101 & 100 = 100 return false
     *          *
     *          * for 6
     *          * 110 & 101 = 100
     *          *
     */
    private static boolean isPowerOfTwo(int num) {
        return num > 0 & (num & (num - 1)) == 0;
    }
}
