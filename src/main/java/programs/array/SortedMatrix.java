package programs.array;

import java.util.Arrays;

public class SortedMatrix {


    public static void main(String[] args) {


        int[][] matrix = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int rows = 4;
        System.out.println(" Matrix : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        sortMatrix(matrix, rows);

        /**
         * 1- first store all the elments in 1 D arrays apply soring in that array
         * 2- fill the matrix of that sorted array data
         */
    }

    public static void sortMatrix(int[][] matrix, int rows) {
        int arr[] = new int[rows * rows];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                arr[k] = matrix[i][j];
                k++;
            }
        }
        System.out.println(" tempArray: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("After sorting tempArray: " + Arrays.toString(arr));

        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            if (col > rows - 1) { // change the row rest the col
                col = 0;
                row++;
                matrix[row][col] = arr[i];
                col++;
            } else {
                matrix[row][col] = arr[i];
                col++;
            }
        }
        System.out.println("Final Sorted Matrix: ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

    }
}



