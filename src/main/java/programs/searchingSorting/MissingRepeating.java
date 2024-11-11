package programs.searchingSorting;
import java.util.Arrays;

public class MissingRepeating {


    public static void main(String[] args) {

//        Missing And Repeating
//        Input: arr[] = [1, 3, 3]
//        Output: 3 2
//        Explanation: Repeating number is 3 and smallest positive missing number is 2.

        int [] arr = {8 ,6, 2, 3, 1, 5, 7 ,4, 10 ,1};
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(findMissingAndRepeating(arr)));
        System.out.println(Arrays.toString(findMissingAndRepeatingOptimized(arr)));
    }

    /**1- brouth force Appoarch
     * 1- first find the repating element from the array
     * 2- use the sorting and check if the current element
     * and previous element is same break and return the current element
     * 3- we can find the missing number first calculate the originalSum using n*(n+1)/2
     * 4- calulate the currentSum
     * 5- repating element = originalSum-(currentSum - repated element)
     **
     */
    private static int[] findMissingAndRepeating(int[] arr) {
        int n = arr.length;
        int repatingElement = -1;
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                repatingElement = arr[i];
                break;
            }
        }
        int originalSum = (n * (n + 1) / 2);
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
        }
        int missingNumber = originalSum - (currentSum - repatingElement);
        return new int[]{repatingElement, missingNumber};
    }

    /**
     * 2- optimal Apporach to use the extra array to check the number is repeating
     * 1- to find the reapting element
     * 2- use the apporach to fill the on the index= (value -1 ) like only add the - sign at the index
     * 3- check if the current element <0 it means current element is repeating element
     * 4- store the repeating element and break it
     * 5- the missing element logic is same
     */
    private static int[] findMissingAndRepeatingOptimized(int[] arr) {
        int n = arr.length;
        int OriginalSum = n * (n + 1) / 2;
        int currentSum = Arrays.stream(arr).sum();
        int repatingElement = -1;
        for (int i = 0; i < n; i++) {
            int originalElement = Math.abs(arr[i]);
            int index = originalElement - 1;
            if (arr[index] < 0) {
                repatingElement = originalElement;
                break;
            }
            arr[index] = -arr[index];
        }
        int missingElement = OriginalSum - (currentSum - repatingElement);
        return new int[]{repatingElement, missingElement};
    }
}
