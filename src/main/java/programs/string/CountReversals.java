package programs.string;

public class CountReversals {
    public static void main(String[] args) {
        //Count the Reversals
//        Input:
//        S = "}{{}}{{{"
//        Output: 3
//        Explanation: One way to balance is:
//        "{{{}}{}}". There is no balanced sequence
//        that can be formed in lesser reversals.
        /**
         * 1- we have to return the number of count that need
         * to make the str valid balanced expression (minimum reversal count)
         * 2- take 3 pointer open , close, rev
         * 3- itrate the str and check if the char is opening bracket then  open++
         * 4- else  char is closing bracket then again check
         *         if  open ==0 the  close++
         *         else open --
         * 5- at the end return Math.cell(open/2.0)+Math.cell(close/2.0);
         */
        String S = "}{{}}{{{";
        System.out.println("str: " + S);
        System.out.println("countReversals: " + countReversals(S));
    }

    private static int countReversals(String s) {
        if (s.length() % 2 != 0) return -1;
        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                open++;
            } else {
                if (open == 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        return (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
    }
}
