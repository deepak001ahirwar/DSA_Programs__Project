package programs.string;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesStr {

    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        String str = "abc";
        // Output : a, b, c, ab, bc, ac, abc
        int n = str.length();
        printSubsequences(str, "");
        System.out.println(" Final :" + list);
    }

    /**
     * 1- use the recursion algorithm to sloved that
     * 2- use the static list<String> which store the result
     * 3- base condtion if the str length is zero then store the anstring to list
     * 4- inside the loop call the same function with str.substring(1), ans+star.char(0)
     * with first char
     * 5- after that again call the same function with str.substring(1), andstring
     */
    private static void printSubsequences(String str, String ans) {
        System.out.println("str :" + str + " AND :" + ans);
        if (str.length() == 0) {
            list.add(ans);
            System.out.println(" ANS: " + ans);
            return;
        }
        // again call the function with the first char
        printSubsequences(str.substring(1), ans + str.charAt(0));

        // again call the function with the remaining chars
        printSubsequences(str.substring(1), ans);
    }
}
