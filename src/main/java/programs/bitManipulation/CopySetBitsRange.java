package programs.bitManipulation;

public class CopySetBitsRange {

    public static void main(String[] args) {

//        Input:
//        X = 44, Y = 3
//        L = 1,  R = 5
//        Output:
//        47
//        Explaination:
//        Binary represenation of 44 and 3 is 101100 and 000011. So in the range 1 to 5 there are two set
//        bits of 3 (1st & 2nd position). If those are set in 44 it will become 101111 which is 47.


    }
    public static int setSetBit(int x, int y, int l, int r) {

        // take 1 bit  shift to r-l+1 range
        int mask = (1 << (r - l + 1));
        // subtract 1
        mask--;
        // shift mask to l-1
        mask = mask << l - 1;
        // AND y and mask
        mask = y & mask;

        // OR with mask , X
        return x | mask;
    }
}
