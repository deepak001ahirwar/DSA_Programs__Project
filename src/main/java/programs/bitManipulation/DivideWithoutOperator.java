package programs.bitManipulation;

public class DivideWithoutOperator {

    public static void main(String[] args) {

//        Division without using multiplication, division and mod operator
//        Input: dividend = 10, divisor= 3
//        Output: 3
//        Exaplanation: 10/3 gives quotient as 3 and remainder as 1.
    }
    public static long divide(long dividend, long divisor) {

        // handle the overflow
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        // The sign will be negative only if sign of
        // divisor and dividend are different
        int sign =((dividend<0)^(divisor<0))?-1:1;
        // remove sign of operands
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize the quotient
        long quotient =0;

        // Iterate from most significant bit to
        // least significant bit
        for( int  i=31 ; i>=0;--i){
            // Check if (divisor << i) <= dividend
            if((divisor<<i)<=dividend){
                // If yes, then subtract divisor << i from
                // dividend and increment the quotient
                dividend -= divisor<<i;
                quotient |= 1L<<i;
            }
        }
        return sign*quotient;
    }

}
