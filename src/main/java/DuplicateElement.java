import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;


public class DuplicateElement {

	public static void main(String[] args) {


		
		
		 
        //***
         //* Approach -1
         //* 1- first check array is sorted or not
        // * 2- take j-0 pointer for put the value 
        // * 3- compare i=0 to i+1 if not equal both 
         //* 4- put arr[j]=arr[i] and j++
		// 5- j to n put 0 in the arrayn
    
		
		int[] arr = {1, 10, 1, 4, 1, 2, 6, 8, 8, 5, 8, 9};
		int len = arr.length;

//		Arrays.sort(arr);
//		System.out.println("after remove duplicate el: "+
//		remove_duplicate(arr,len));
		
		System.out.println("unsorted array: "+unsortedArr_duplicate(arr,len));
	   
	}
	public static int[] unsortedArr_duplicate(int arr[], int N) {
		
		
//		HashMap<Integer,Integer> map= new LinkedHashMap<>();	
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int nums : arr) {
			if (map.containsKey(nums)) {
				map.put(nums, map.get(nums) + 1);
			} else {
				map.put(nums, 1);
			}
		}
		System.out.println("Map Data: "+map);
		System.out.println("Size: "+map.size()+" "+map.keySet().size());
		
		int tempArr[]= new int[map.keySet().size()];
		
		int j=0;
		for(Integer  tempMap:map.keySet()) {		
			tempArr[j]=tempMap;
			j++;
		}
		
		System.out.println("tempArr :"+Arrays.toString(tempArr) );
		
		return tempArr;
		
		
	}
	
	public static int remove_duplicate(int A[],int N){

		int j=0;
		for(int i=0;i<N-1;i++){
			//compare i and i+1 and store in j index 
			if(A[i]!=A[i+1]){
				A[j]=A[i];
				j++;
			}
		}
		// for last element
		A[j]=A[N-1];
		j++;
		for(int k=j;k<N;k++){
			A[j]=0;
			j++;
		}
		int uniqueNum=0;
		for(int num:A){
			if(num>0){
				uniqueNum++; 
			}
		}
		System.out.println("Fianal Array : "+Arrays.toString(A) );
		return uniqueNum;
	}
	   
	   
	   
	   
	

}
