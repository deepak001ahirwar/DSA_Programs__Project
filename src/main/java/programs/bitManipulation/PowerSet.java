package programs.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {



    }

    /**
     * 1- first use the ArrayList to store the subSequence
     * 2- itrate the loop until i< 2^n -1 (we can say (1<<n))
     * 3- inside the use another loop start from 0 to n
     * 4- check if the i&(1<<j) >0  the we simply store in str=str+s.charAt(j)
     * 5- oue side the loop we check if str,not empty the store to list
     * 6- at the end sort the list
     */
    public List<String> AllPossibleStrings(String s) {
        List<String> a = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < (1 << n); i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    str += s.charAt(j);
                }
            }
            if (!str.isEmpty()) {
                a.add(str);
            }
        }
        Collections.sort(a);
        // Code here
        return a;
    }
}
