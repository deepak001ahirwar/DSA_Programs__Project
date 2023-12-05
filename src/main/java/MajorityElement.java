import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {

		
		/***
		Approach -1
		1- use hasmap store elemnt with count and then 
		2- itrate map and compare the count with n/2 
		3- if greater then return 
		 */		
		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
//		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
//		int size=arr.length;
//		for (int i = 0; i < arr.length; i++) {
//			if (freqMap.containsKey(arr[i])) {
//				freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
//			} else {
//				freqMap.put(arr[i], 1);
//			}
//		}
//		System.out.println("freqMap =>" + freqMap);
//		int majElmnt=0;
//		for (Map.Entry<Integer, Integer> dataMap : freqMap.entrySet()) {			
//			if(dataMap.getValue()>size/2) {
//				majElmnt=dataMap.getKey();
//				break;
//			}			
//		}
//		System.out.println("majElmnt =>" + majElmnt);	
		
		
		//Moore’s Voting Algorithm:
		int count=0, ret = 0;
	    for (int num: arr) {
	        if (count==0)
	            ret = num;
	        if (num!=ret)
	            count--;
	        else
	            count++;
	    }
	    System.out.println("ret "+ret);
	}

}
