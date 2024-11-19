package programs.array;

public class CountAndSay {


    public static void main(String[] args) {

        int n = 4;

        //base case countAndSay(1) = "1"
        //countAndSay(n) is the run-length encoding of countAndSay(n - 1).


        /** 1- apply the recursion algorithm
         *
         * 1- as give the question used the base case count
         * 2- first we find out the n string says like sample String
         * 3- call the recursion for previous n  if CountSay() method for imple
         *     countSay(n-1)
         * 4- at the last we iterate the loop and store the combination of count+say(actual number) in String
         * increase the Counter
         * 5- return it and counter=0
         *
         */

        System.out.println("Actual Number: "+n);
        System.out.println("countAndSay:"+countAndSay(n));
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // call the same function as recursively for n-1
        String preStr = countAndSay(n - 1);
        System.out.println( " preStr :"+preStr );
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < preStr.length(); i++) {
            count++;  // increase count for same characters consecutively
            if (i==preStr.length()-1||preStr.charAt(i) != preStr.charAt(i + 1)) {
                sb.append(count).append(preStr.charAt(i));
                count = 0;
            }
        }
        return sb.toString();

    }
}
