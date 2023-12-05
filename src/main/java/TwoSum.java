import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    
    public static void main(String[] args) {
        
        int [] nums = {2,7,11,15,16};
        int target = 26;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    public  static int[] twoSum(int[] nums, int target) {
        

        /**
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
            Appoach 1-
            1- using 2 for loop and check for every element pair
            2- and return index         
            Approach -2
            1- using the hashMap 
            2- store all element in hashMap
            3- search the rem=target-num[i];
            4- if present then return the rem index and current index 
         */

         //Apporach -1
        //  for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int []{i,j};
        //         }
        //     }
        //  }
        //  return null;
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> innerlist= new ArrayList<>();
        
        
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int arr[] = new int[2];
			for (int i = 0; i < nums.length; i++) {
				int rem = target - nums[i];
				if (map.containsKey(rem)) {
					arr[0] = map.get(rem);
					arr[1] = i;
				} else {
					// store in hashMap
					map.put(nums[i], i);
				}
        }
        return arr;


    }
}
