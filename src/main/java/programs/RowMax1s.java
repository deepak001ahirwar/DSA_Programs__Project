package programs;

public class RowMax1s {

    public static void main(String[] args) {


        int matrix[][] = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        int row = 4;
        int col = 4;
        System.out.println(" rowMax1s:  " + rowMax1s(matrix, row, col));
    }
    /** 1- brouth forch apporach
     *  1- apply 2 for loop check for every row number of 1 and save the index of row
     *  O(n*M)
     */


    /**
     * 2- optimal apporach  use the binary serach for row data searching in matrix
     * O(n*log n )
     * 1- take 2 pointer tempMax=-1 and  finalindex =0
     * 2- itrate the matrix row by row inside the loop
     * 3-  binary search calculate the start=0 and end=col-1 , mid=start+(end-start)/2
     * 4- check if the matrix[i][mid]==1 then we move to left side end=mid-1
     * 5- else we move to right side start=mid+1
     * 6- outer side the binary search loop we check if the start<tempMax the
     * update the tempMax with start and  finalindex with current row index
     */


    public static int rowMax1s(int[][] matrix, int row, int col) {

        int tempMax = Integer.MAX_VALUE;
        int finalindex = -1;
        // itrate the matrix row by row
        for (int i = 0; i < row; i++) {
            //apply binary search inside the loop
            int start = 0;
            int end = col - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] == 1) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // edge case to not start value is more then the  last index of col
            if (start < tempMax && start < col) {
                tempMax = start;
                finalindex = i;
            }
        }
        return finalindex;

    }

    /**
     * 3- optimal best less time complicity
     * <p>
     * 1- itrate the matrix row by row using for loop
     * 2- inside the for loop start from last col index and check if the current elemnt is 1 or not
     * 3-  from the last col to first col of every row , if the current elemnt is 1 then no need to check the next row move to next col-- and  update the
     * current row index
     * 4- otherwise move to next row using break inner loop
     */

    public static int bestoptimalrowMarix1s(int[][] matrix, int row, int col) {

        int finalCol = col - 1;
        int rowindex = -1;
        for (int i = 0; i < row; i++) { // itrate row by row
            for (int j = finalCol; j >= 0; j--) {
                // no need to check in the  next row skip it move to next col
                if (matrix[i][j] == 1) {
                    rowindex = i;
                    finalCol--;
                } else {   // it means got the zero brak that loop move to next row or check in next row
                    break;
                }
            }
        }
        return rowindex;

    }
}
