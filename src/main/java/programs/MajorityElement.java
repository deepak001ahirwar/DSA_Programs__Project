package programs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {

//		Input: arr[] = [3, 1, 3, 3, 2]
//		Output: 3
//		Explanation: Since, 3 is present more than n/2 times, so it is the majority element.
		/***
		Approach -1
		1- use hasmap store elemnt with count and then 
		2- itrate map and compare the count with n/2 
		3- if greater then return 
		 */		
//		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
		int[] arr = { 2,13 };
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		int size=arr.length;
		System.out.println( getMajorityOptimal(arr));
//		for (int i = 0; i < arr.length; i++) {
//			if (freqMap.containsKey(arr[i])) {
//				freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
//			} else {
//				freqMap.put(arr[i], 1);
//			}
//		}
//		Arrays.stream(arr).forEach(ans->{
//			System.out.print(ans + " ");
//			freqMap.put(ans, freqMap.getOrDefault(ans, 0)+1);
//		});

//		for(Integer ans:arr){
//			freqMap.put(ans, freqMap.getOrDefault(ans, 0)+1);
//		}
//		System.out.println("freqMap =>" + freqMap);
//		int majElmnt = 0;
//		for (Map.Entry<Integer, Integer> dataMap : freqMap.entrySet()) {
//			if (dataMap.getValue() > size / 2) {
//				majElmnt = dataMap.getKey();
//				break;
//			}
//		}
//		System.out.println("majElmnt =>" + majElmnt);
		
		
//		//Moore’s Voting Algorithm:
//		int count=0, ret = 0;
//	    for (int num: arr) {
//	        if (count==0)
//	            ret = num;
//	        if (num!=ret)
//	            count--;
//	        else
//	            count++;
//	    }
//	    System.out.println("ret "+ret);

	}
	/**Moore Voting algorithm
	 * 1- this tell us if the elements  comes in the array is n/2 more then time
	 * 2- it means remaining is less then n/2 times
	 * 3- take the two variable vote =0, candidate =0
	 * 4- itrate the loop and check if the vote==0 it means its first elment
	 * 5- candidate = arr[i] ,vote =1
	 * 6- check if the arr[i]==candidate vote++
	 * 7- else vote--
	 * 8- check if the candidate is not majority then return -1;
	 *
	 */
	public static int getMajorityOptimal(int arr[]){
		int len =arr.length;
		int majorityIndex = -1, vote = 0,candidate = 0;
		for(int i=0; i<arr.length; i++){
			if(vote == 0){
                candidate = arr[i];
                vote = 1;
            } else {
				if (arr[i] == candidate) {
					vote++;
				} else {
					vote--;
				}
			}
		}

		// check the majorty
		int count =0;
		for(int i = 0; i < len; i++) {
			if(arr[i] == candidate) {
				count++;
            }
		}
		return	(count > len/2 )?candidate :-1;
	}

}
