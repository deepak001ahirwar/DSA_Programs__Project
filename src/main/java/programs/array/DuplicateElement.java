package programs.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DuplicateElement {

	public static void main(String[] args) {

        //***
         //* Approach -1
         //* 1- first check array is sorted or not
        // * 2- take j-0 pointer for put the value 
        // * 3- compare i=0 to i+1 if not equal both 
         //* 4- put arr[j]=arr[i] and j++
		// 5- j to n put 0 in the arrayn
    
		
		int[] arr2 = {1, 10, 1, 4, 1, 2, 6, 8, 8, 5, 8, 9};
		int len2 = arr2.length;

//		Arrays.sort(arr);
//		System.out.println("after remove duplicate el: "+
//		remove_duplicate(arr,len));
		
		System.out.println("unsorted array: "+unsortedArr_duplicate(arr2,len2));

		////
		// print the duplicate
		int arr [] = {1,2,3,1,2,4};

		// 1- using the 2 loop
		List<Integer> duplicate = new ArrayList<>();
		int len = arr.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(arr[i]==arr[j]){
					duplicate.add(arr[i]);
				}
			}
		}
		// 2- using map
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		Arrays.stream(arr).forEach(temp -> {
					hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
				}
		);
		List<Integer> list = hashMap.entrySet().stream()
				.filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey).toList();
		System.out.println("duplicate Arrays: "+duplicate);

		// remove the duplicate from the Arrays
		// o/p = 1,2,3,4
	   
	}
	public static int[] unsortedArr_duplicate(int arr[], int N) {

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
