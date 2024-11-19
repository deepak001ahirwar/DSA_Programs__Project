package programs.array;

public class SmallestSubArray_greatherSum {


    public static void main(String[] args) {

        int arr[] = {1, 4, 45, 6, 0, 19};
        int x = 51;
        System.out.println(smallestSubarr(arr, x));
    }

    /*Algo- O(n2)
    1- find out every sub array and check if the sum of subarray is grether then
    2- find the min of number of element of subarray
    3- inner loop use for calculate the sum of sub array and find the finalMin
    4- outer loop every pair of sub array
     */
    public static int smallestSubarr(int arr[], int x) {
        int len = arr.length;
        int finalMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum = sum + arr[j];
                System.out.println("sum: " + sum + " tempCount: " + (j - i + 1));
                if (sum > x) {
                    finalMin = Math.min(finalMin, j - i + 1);
                    break;
                }
            }
            System.out.println("finalMin: " + finalMin);
        }
        return Math.max(finalMin, 0);
    }


    /**
     * 2- second apporach use the sliding windows problem
     * 1- take the curr_sum=0, min_len=n+1 for min length of elemnt
     * 2- take  two pointer start  =0 and end =0
     * 3- itrate the loop until the end <n
     * 4- use the end pointer for store the curr_sum until reach the x (desired sum) curr_sum < X
     * 5- use the start pointer for remove the current element from curr_sum until curr_sum > x
     * 6- same the case we take the min_len from end-start which is less
     * 7- return the min_len
     *
     */
    public static  int optimalSmallestSubArr(int arr[],int X) {
        int curr_sum = 0, len = arr.length, min_len = len + 1;
        int start = 0, end = 0;
        while (end < len) {
            // check if the current is less then the X ,
            // till add the arr[end] in the curr_sum and increase the end
            while (curr_sum < X && end < len) {
                curr_sum += arr[end];
                end++;
            }
            // check if the curr_sum reach > X then remove the arr[start]
            // and increase the start
            while (curr_sum > X && start < len) {
                if (end - start < min_len) {
                    min_len = end - start;
                }

                curr_sum -= arr[start];
                start++;
            }
        }
        return min_len;

    }
}
