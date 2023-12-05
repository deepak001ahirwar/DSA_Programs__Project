import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeArrayIntersection {

	/*Given three Sorted arrays in non-decreasing order, 
	print all common elements in these arrays.
	case 1- also added the duplicate number	
	Input: 
		ar1[] = {1, 5, 10, 20, 40, 80} 
		ar2[] = {6, 7, 20, 80, 100} 
		ar3[] = {3, 4, 15, 20, 30, 70, 80, 120} 
		Output: 20, 80
		Input: 
		ar1[] = {1, 5, 5} 
		ar2[] = {3, 4, 5, 5, 10} 
		ar3[] = {5, 5, 10, 20} 
		Output: 5, 5 */	
	public static void main(String[] args) {

		int num1[]= {1, 5, 5};
		int num2[]= {3, 4, 5, 5, 10};
		int num3[]= {5, 5, 10, 20};
		
		System.out.println(Arrays.toString(intersection3Array(num1, num2, num3)));		
		
	}
	
	
	public static int[] intersection3Array(int num1[], int num2[],int num3[]) {			
		int i=0,j=0,k=0;
		// use 3 pointer apporach to and compare num1 and num2 ,
		//then num2 and num3  make sure arrays are sorted		
		List<Integer> lst= new ArrayList<>();
		while(i<num1.length&&j<num2.length&&k<num3.length) {		
			if(num1[i]==num2[j]&&num2[j]==num3[k]) {				
				lst.add(num1[i]);
				i++;
				j++;
				k++;
			}
			else if(num1[i]<num2[j]) {				
				i++;
			}else if(num2[j]<num3[k]) {				
				j++;				
			}else {
				k++;
			}			
		}	
		int arr[]= new int[lst.size()];
		int l=0;		
		for(int item: lst) {
			arr[l]=item;
			l++;
		}		
		return arr;
	}

}
