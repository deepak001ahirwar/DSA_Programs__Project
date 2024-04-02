package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NByKtimesMaxElement {

	public static void main(String[] args) {

		int arr[] = {3, 1, 2, 2, 1, 2, 3, 3};
		int k = 4;
		
		System.out.println(" REsult: "+Arrays.toString(nbykMaxElemnt(arr,k)));
		
	}

	public static Integer[] nbykMaxElemnt(int arr[],int k) {	
		
		HashMap<Integer,Integer> map= new HashMap<>();
		for(Integer itr:arr) {
			if(map.containsKey(itr)) {
				map.put(itr, map.get(itr)+1);
			}else {
				map.put(itr, 1);
			}
		}
		System.out.println("map : "+map);
		
		int nbyk=arr.length/k;
		
		
//		int result[]= {};
		List<Integer> list= new ArrayList<>();
		for(Entry<Integer, Integer> tempMap:map.entrySet()) {
			
			Integer key=tempMap.getKey();
			Integer value=tempMap.getValue();
			if(value>nbyk) {
				list.add(key);
			}
			
		}
		Integer result[]= list.toArray(new Integer[0]); 
//		result=list.toArray();
		
		return result;
	}
}
