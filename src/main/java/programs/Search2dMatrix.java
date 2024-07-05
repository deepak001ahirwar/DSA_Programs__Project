package programs;

public class Search2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 34;
//        System.out.println(searchMatrix(matrix, target));

        System.out.println(searchMatrixBybinarySearch(matrix, target));
        /**
         * a- brouth forch algorithm O(n*m)
         *
         * 1- first we use the outer loop for itrate the number of rows
         * 2- inside we use the inner loopfor num of colums
         * 3- check that if matrix[i][j] is equals to target return true otherwise false
         */

        /**
         * b- second apporach use the binnary search for inner loop that reuced the complecity
         * 1- first outter loop for number of rows
         * 2- inside the for numbers of colmns are sorted the we can apply the binnary search
         */
    }

    public static boolean searchMatrixBybinarySearch(int[][] matrix, int target) {

        for(int i=0; i<matrix.length; i++) { // no rows
            if(binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
