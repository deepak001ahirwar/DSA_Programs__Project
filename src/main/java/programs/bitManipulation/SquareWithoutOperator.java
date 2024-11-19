package programs.bitManipulation;

public class SquareWithoutOperator {
    public static void main(String[] args) {

//        Calculate square of a number without using *, / and pow()


        int num = 9;
//        System.out.println("Square of " + num + " without using operator: " + square(num));
        System.out.println("Square of " + num + " without using operator: " + squareOptimal(num));
    }

    /**
     * 1- add the same num the number of times got the square of the number
     *
     */
    private static int square(int num) {
        if (num < 0) {
            num = -num;
        }
        int result = num;
        for (int i = 1; i < num; i++) {
            result += num;
        }
        return result;
    }

    /**
     * B- Optimal use of bit multiplication
     */
    private static int squareOptimal(int num) {
        // Base case
        if (num == 0)
            return 0;
        if (num < 0) {
            num = -num;
        }
        // Get floor(n/2) using
        // right shif
        int floor = num >> 1;

        if (num % 2 == 0) {
            return (square(floor) << 2);
        } else {
            return ((square(floor) << 2) + (floor << 2) + 1);
        }
    }


    }


