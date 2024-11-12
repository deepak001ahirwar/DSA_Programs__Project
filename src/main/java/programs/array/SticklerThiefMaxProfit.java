package programs.array;
public class SticklerThiefMaxProfit {


    public static void main(String[] args) {



//        Stickler Thief
//        Input:
//        n = 5
//        a[] = {6,5,5,7,4}
//        Output:
//        15
//        Explanation:
//        Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6+5+4=15

        /**
         *
         *
         */
        int n = 6;
        int[] a = {9, 4, 11, 12, 6,12};
        System.out.println(maxLoot(a, n));
    }

    /** 1- take the two pointer prev1,prev2
     * 2- prev1=arr[0],prev2=0
     * 3- iterate the loop i - 1 to n times
     * 4- take = arr[i]+prev2 // current+prev2
     * 5- non_take=prev1; // non_take is prev1
     * 6- curr=max(take,non_take); // calculate the max of take and non_take
     * 7- update the prev2=prev1
     * 8- update prev1=curr
     * 9- return prev1
     */
    private static int maxLoot(int[] arr, int n) {
        int prev1 = arr[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = arr[i] + prev2;
            int non_take = prev1;
            int curr = Math.max(take, non_take);
            prev2 = prev1;
            prev1 = curr;
            System.out.println( );
        }
        return prev1;
    }


    // not good apporach not pass the test cases
//    private static int  maxLoot(int[] arr, int n) {
//       int evenSum = 0;
//        for(int i = 0; i < arr.length; i=i+2){
//            evenSum += arr[i];
//        }
//        int oddSum=0;
//        for(int i = 1; i < arr.length; i=i+2){
//            oddSum += arr[i];
//        }
//       return Math.max(oddSum, evenSum);
//    }
}
