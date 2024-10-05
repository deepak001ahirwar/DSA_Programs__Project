package programs.string;

public class MinimumAdjacentSwapsBracket {

    public static void main(String[] args) {
//        Input  : []][][
//        Output : 2
//        Explanation :
//        First swap: Position 3 and 4 [][]][
//        Second swap: Position 5 and 6 [][][]
        /**1- we only find the non pair of brackets and calculate the min swap to make it vaild
         * 2- first take 4 pointer open=0,close=0,swap=0,Unbalanced=0;
         * 3- itrate the loop check if the character open bracket like '['  then open++
         * 4- inside the check if unbalanced>0 then swap+= unbalanced and unbalanced --,
         * 5- if the current char ']' then update ++, unbalanced= close-open;
         */
        String input = "[]][][";
        System.out.println("Minimum swaps needed: " + minSwaps(input));
        /// leetcode problem
    }

    private static int minSwaps(String input) {
        int open = 0, close = 0, swaps = 0, unbalanced = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                open++;
                if (unbalanced > 0) {
                    swaps += unbalanced;
                    unbalanced--;
                }
            } else {
                close++;
                unbalanced = close - open;
            }
        }
        return swaps;
    }
}
