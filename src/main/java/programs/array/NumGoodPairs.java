package programs.array;
import java.util.HashMap;

public class NumGoodPairs {


    public static void main(String args[]){

    	
    	/**
    	 * 
    	 * Input: nums = [1,2,3,1,1,3]
			Output: 4
			Explanation: There are 4 good pairs (0,3), (0,4), 
			(3,4), (2,5) 0-indexed.

    	 */
		int nums[] = { 1, 2, 3, 1, 1, 3 };
		HashMap<Integer, Integer> map = new HashMap<>();
//		int ans = 0;
//		for (int data : nums) {
//			int val = map.getOrDefault(data, 0);
//			ans = ans + val;
//			map.put(data, val + 1);
//		}
//System.out.println(" ans : "+ans);
//
		
		int res=0;
		for (int Data : nums) {
			if (map.containsKey(Data)) {
				res=res+map.get(Data);
				map.put(Data, map.get(Data) + 1);				
			} else {
				map.put(Data, 1);
			}
		}
		
		System.out.println("Map Data: "+map+" RES :"+res);
		
    }
    
}
