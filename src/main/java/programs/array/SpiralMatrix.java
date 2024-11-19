package programs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {


    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 1- Apporach matrix spiral
        // right => bottom => left => top
        /**  we can update these pointer to print and make the spiral matrix complate 1 loop
         *  a- top goes to top ++ ;
         *   b- bottom goes to bottom --;
         *   c- left goes to left++;
         *   d- right goes to right--
         */

        /*
         * 1- itrate the while loop until top <= bottom && left <= right
         * 2- inside the lopp we use the four times for loop for right => bottom => left => top
         *    and store the result in List<Integer> list
         * 3- (i) ==  //right movment   from  that we move from left=> right( column)  and top is stable (row)
         *             store the result in List<Integer> list = arr[top][i] and top++;
         *    (ii)== //bottom  from that we move from i= top=> bottom(row) and right is stable (column)
         *            store the result in List<Integer> list = arr[i][right] and  right--;
         *    (iii) == // left  from that we move from i= right => left (column) and bottom is stable (row)
         *            store the result in List<Integer> list = arr[bottom][i] and bottom --;
         *           this also check that top<=bottom  inside the loop
         *    (iv) == // top from that we move from i= bottom=> top (row) and left is stable (column)
         *          store the result in List<Integer> list = arr[i][left] and left++;
         *         this also check left <= right inside the loop
         *  4- return the list;
         */
        System.out.println("before the matrix : "+ Arrays.toString(matrix));
        System.out.println("Result : " + getSpiralMatrix(matrix));
    }


    public static List<Integer> getSpiralMatrix(int matrix[][]) {

        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Number of rows :" + m);
        System.out.println("Number of columns :" + n);
        int top = 0, bottom = m - 1,
                left = 0, right = n - 1;
        List<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right) {

            // right  position movement
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            System.out.println("After right movement : " + list);

            // bottom position movement
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            System.out.println("After bottom movement : " + list);

            //left position movement
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // top position movement
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }


        }

        System.out.println("final List of SpiralMaxtrix: " + list);
        return list;
    }
}
