package programs.array;

import java.util.Arrays;

public class MedianRowwiseMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int row = 3;
        int col = 3;
//        System.out.println("Matrix Median: " + getMedianRowwiseMatrix(matrix, row, col));
        System.out.println("Matrix Median Optimal : " + optimalgetMedianRowwiseMatrix(matrix, row, col));

    }

    /**
     * 1- brouth forch apporach   time complxity : O(N*M)
     * 1-first itrate the whole 2D matrix and store in 1D array
     * 2- sort the 1D array
     * 3- if the array size is even the return arr[n/2-1]+arr[n/2]
     * 4- else return arr[n/2]
     */

    public static int getMedianRowwiseMatrix(int[][] matrix, int row, int col) {
        int arr[] = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[index] = matrix[i][j];
                index++;
            }
        }
        System.out.println("before  sort: " + Arrays.toString(arr));
        // sort the arrays
        Arrays.sort(arr);
        // calculate median
        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]);
        } else {
            return arr[n / 2];
        }
    }


    /**
     * 2- second optimal apporach
     * <p>
     * 1- we apply the 2 time of binary search in that question
     * 2- start=1, end =2000 as given in the question  median=n/2 , assumenmedian=start+(end-start)/2
     * 3- apply the binary search for it and inside calculate the number of <= elemnt of that assumeMedian
     * 4- if the templessellemnt <=medain then start=assumenmedian+1
     * 5- else end= assumenmedian-1;
     * 6- return the start that reach at the medain postions
     * <p>
     * <p>
     * 1- calculateLessElement(matrix, assumeMedian)
     * 2- itrate the matrix row by row that is already sorted so we can apply the binary search
     * 3- for(int i=0;i<matrx.length;i++){}
     * 4- inside the loop apply binary search  start =0; end =matrix[i].length-1,
     * mid=start+(end-start)/2
     * 5-     check that if the matrix[i][mid]<=assumeMedian then start=mid+1;
     * 6- else end=mid-1;
     * 7- start the start value every time in numoflesserElement
     * numoflesserElement+ = start;
     * 8- return numoflesserElement;
     */

    public static int optimalgetMedianRowwiseMatrix(int matrix[][], int row, int col) {
        int start = 1, end = 2000;
        int medain = (row * col) / 2;
        while (start <= end) {
            int assumeMedian = start + (end - start) / 2;
            // calculate number of elements <= assumeMedian
            int lesserElement = calculateLesserElement(matrix, assumeMedian);
            if (lesserElement <= medain) { // compare with  medain
                start = assumeMedian + 1; // search in right subarray
            } else {
                end = assumeMedian - 1; // search in left subarray
            }
        }
        return start;
    }

    public static int calculateLesserElement(int matrix[][], int assumeMedian) {
        // itrate the matrix row by row
        int numLessElement = 0;
        for (int i = 0; i < matrix.length; i++) {
            int start = 0, end = matrix[i].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] <= assumeMedian) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            numLessElement += start;
        }
        return numLessElement;
    }


}
