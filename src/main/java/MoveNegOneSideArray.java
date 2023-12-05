import java.util.Arrays;

public class MoveNegOneSideArray {

	public static void main(String[] args) {

//      Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
      	//    i								 j
      ////                     i       j
      //       -12  -6  -13 -5 6 -7 5 -3 11
      //        
//      Output: -12 -13 -5 -7 -3 -6 11 6 5
      
      /****
       * Apporach -1
       * use 2 pointer Apporach and while inside while
       * loop increase i and decreases j swap the element 
       */
      int arr2[]= {-12, 11, -13, -5, 6, -7, 5, -3, -6};        
      int i=0;
      int j=arr2.length-1;      
		while (i < j) {
			while (i < j && arr2[i] < 0) {
				i++;
			}
			while (j > i && arr2[j] > 0) {
				j--;
			}
			int temp = arr2[i];
			arr2[i] = arr2[j];
			arr2[j] = temp;
		}
		System.out.println(Arrays.toString(arr2));     
	}

}
