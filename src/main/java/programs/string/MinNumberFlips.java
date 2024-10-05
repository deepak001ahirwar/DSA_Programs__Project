package programs.string;

public class MinNumberFlips {
    public static void main(String[] args) {
        //Min Number of Flips (GFG)
//        Input:
//        S = "001"
//        Output: 1
//        Explanation:
//        We can flip the 0th bit to 1 to have
//        101.\
        String str = "001";
        System.out.println("minNumberFlips : " + minNumberFlips(str));
    }

    /**
     * 1- we assume the even index end with 1 and odd index end with 0
     * 2- take the flip counter
     * 3- itrate the loop from 0 to length of str
     * 4- if the index is even (i%2==0)  inside that check str.charAt(i) == 0
     * 5- then flip ++
     * 6- else  for odd index of bit , check if str.charAt(i) == 1 then flip ++
     * 7- retunr teh
     */

    private static int minNumberFlips(String str) {
        // we assume end (even)0-index  with 1 and (odd)index with 0
        int flips = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                if (str.charAt(i) == '0') {
                    flips++;
                }
            } else {
                if (str.charAt(i) == '1') {
                    flips++;
                }
            }
        }
        // we did for min of flip and second apporach flip
        return Math.min(flips, str.length() - flips);
    }
}
