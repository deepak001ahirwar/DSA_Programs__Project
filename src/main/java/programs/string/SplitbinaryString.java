package programs.string;

public class SplitbinaryString {
    public static void main(String[] args) {
        /**Split the binary string into substrings with equal number of 0s and 1s
         * Input: str = “0100110101”
         * Output: 4
         * The required substrings are “01”, “0011”, “01” and “01”.
         * 1-first itrate the Str char by char
         * 2- tale 2 pointer countO,count1 for manaitning the freq of 0 and 1
         * 3- finalCount if the countO==count1 finalCount++
         * 4- at the end if the countO!=count1 then return -1
         */

        String str = "0100110101";
        System.out.println("Str: " + str);
        System.out.println("splitBinaryString: " + splitBinaryString(str));
    }

    private static int splitBinaryString(String str) {
        int count0 = 0, count1 = 0;
        int finalCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                count0++;
            } else {
                count1++;
            }
            if (count0 == count1) {
                finalCount++;
            }
        }
        if (count0 != count1) {
            return -1;
        }
        return finalCount;
    }
}
