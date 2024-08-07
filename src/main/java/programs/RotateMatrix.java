package programs;

public class RotateMatrix {

    public static void main(String[] args) {

        int matrix[][] = {{1, 2, 3},
                         {4, 5, 6},
                          {7, 8, 9}};
        int row = matrix.length;
        int col = matrix[0].length;
        rotateImage(matrix, row, col);

    }

    /**
     * brouth forch apporach used the another matrix
     * 1- itrate the row by row from last row to first row
     * 2- store in new matrix colum by coln
     * 3- it will convert row into col
     */

    public static void rotateImage(int matrix[][], int row, int col) {
        int tempMat[][] = new int[row][col];
        int tempcol = 0;
        for (int i = row - 1; i >= 0; i--) { // row wise
            for (int k = 0; k < row; k++) { // row
                tempMat[k][tempcol] = matrix[i][k];
            }
            tempcol++;
        }
        // print Matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tempMat[i][j] + " ,");
            }
            System.out.println();
        }

    }
    /** optimal Apporach
     * 1- first transponces the matrix swap the matrix [i][j] to matrix[j][i]
     * 2- using two loop and j is dependent on i , j=i+1;
     * 3- rever the matrix of every row
     * 4- it will become the rotateImage or rotateMatrix
     */

    public static void optmialRotateMatrix(int matrix[][], int row,int col){

        for( int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){
                swap(i,j,matrix);
            }
        }
        System.out.println(" Transpose MAtrix: ");
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]+" ,");
            }
            System.out.println();
        }
        // reverse the matrix row by row
        reverseMatrixRowbyRow(matrix,row,col);
    }

    private static void reverseMatrixRowbyRow(int[][] matrix ,int row,int col) {
        for(int i=0;i<row;i++){
            int arr[] = matrix[i];
            int start=0;int end =arr.length;
            while(start<end){
                int temp=matrix[i][end];
                matrix[i][end]=matrix[i][start];
                matrix[i][start]=temp;
                start++;
                end--;
            }
        }
    }
    private static void swap(int i, int j,int matrix[][]) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
