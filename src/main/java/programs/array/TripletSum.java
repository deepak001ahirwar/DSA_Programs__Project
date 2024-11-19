package programs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripletSum {

	public static void main(String[] args) {


//		Input: nums = [-1,0,1,2,-1,-4]
//		Output: [[-1,-1,2],[-1,0,1]]
//		Explanation:
//		nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//		nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//		nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//		The distinct triplets are [-1,0,1] and [-1,-1,2].
//		Notice that the order of the output and the order of the triplets does not matter.

		int arr[] = {-1,0,1,2,-1,-4};
//			{ 1, 4, 45, 6, 10, 8 };
		int result = 13;
//		System.out.println(threeSum(arr,result));
//		System.out.println(optimizedthreeSum(arr,result));
//		System.out.println(threeSum(arr));
//		System.out.println(threeSum2(arr));
		System.out.println(threeSum3(arr));
	}	
	//Apporach 1- brute force 
	/**
	 * 1- used the 3 loop for every element of array 
	 * 
	 */
	public static List<List<Integer>> threeSumtakeUforwardOptimized(int [] arr){
        List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		int len=arr.length;
		for(int i=0;i<len;i++) {			
			// skip the duplicate 
			if(i!=0&&arr[i]==arr[i-1]) {
				continue;
			}			
			//start the 2 pointer 			
			int j=i+1;
			int k=len-1;
			
			while(j<k) {
				int sum=arr[i]+arr[j]+arr[k];
				if(sum>0) {
					k--;
				}else if(sum<0) {
					j++;
				}else {
					List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k]);				
					ans.add(temp);
					j++;
					k--;				
					// check if the current and adjecent is 
                    //then move to next value				
					while(j<k&& arr[j]==arr[j-1])
						j++;				
					while(j<k&&arr[k]==arr[k+1])
						k--;
				}				
			}		
		}
		return ans;		
	}

	/** we should use the O(n2) time complexity , use the Hashset O(N)
	 *
	 * 1- find the third elements from sum of 2 elements
	 * thrid=-(arr[0]+arr[j])
	 * 2- check the third elements present in hashSet
	 * 3- if present then save in temp hashset and sort for unique elements
	 * 4- stored the temp hashset into final result
	 * 5- at the end of second loop store the arr[j] into hashset
	 */
	public static List<List<Integer>> threeSumtakeUforwardtwoloop(int [] arr) {
		Set<List<Integer>> st = new HashSet<>();
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			Set<Integer> hashset = new HashSet<Integer>();
			for (int j = i + 1; j < len; j++) {
				int third = -(arr[i] + arr[j]);
				if (hashset.contains(third)) {
					List<Integer> templs = Arrays.asList(arr[i], arr[j], third);
					templs.sort(null);
					st.add(templs);
				}
				hashset.add(arr[j]);
			}
		}
		List<List<Integer>> result = new ArrayList<>(st);
		return result;
	}
	/** B-  using 2 loop with Map
	 *
	 */
	public  static List<List<Integer>> threeSum(int[] nums) {
		System.out.println(Arrays.toString(nums));
		List<List<Integer>> result= new ArrayList<>();
		int n=nums.length;
		int X=0;
		for (int i = 0; i < n; i++) {
//			int temp=X-nums[i];
			Map<Integer,Integer> map= new HashMap<>();
			List<Integer> tempResult= new ArrayList<>();
			for(int j=i+1;j<n;j++) {
				if(map.containsKey(X-nums[i]-nums[j])) {
					tempResult.add(nums[i]);
					tempResult.add(nums[j]);
					tempResult.add(X-nums[i]-nums[j]);
				}else {
					map.put(nums[j], 1);
				}
			}
			result.add(tempResult);
		}
		return result;
	}

	/**
	 * using 3 loop O(N^3)
	 */
	public static List<List<Integer>> threeSum3(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }



	/**
	 * C- Optimized version of
	 *
	 * */
	public static List<List<Integer>> threeSum2(int nums[]) {
//		int len = arr.length;
		System.out.println(Arrays.toString(nums));
//		HashSet<List<Integer>> result = new HashSet<>();
//		for (int i = 0; i < len; i++) {
//			for (int j = i + 1; j < len; j++) {
//				List<Integer> tempResult = new ArrayList<>();
//				for (int k = j + 1; k < len; k++) {
//					if (arr[i] + arr[j] + arr[k] == 0) {
//						tempResult.add(arr[i]);
//						tempResult.add(arr[j]);
//						tempResult.add(arr[k]);
//					}
//				}
//				if (tempResult.size() > 0) {
//					result.add(tempResult);
//				}
//			}
//		}
//
//		System.out.println("result: "+result.toString());
		Arrays.sort(nums);
		List<List<Integer>> answer = new ArrayList<>();
		if (nums.length < 3) {
			return answer;
		}
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum > 0) {
					high--;
				} else if (sum < 0) {
					low++;
				} else {
					answer.add(Arrays.asList(nums[i], nums[low], nums[high]));
					int lastLowOccurrence = nums[low];
					int lastHighOccurrence = nums[high];

					while (low < high && nums[low] == lastLowOccurrence) {
						low++;
					}
					while (low < high && nums[high] == lastHighOccurrence) {
						high--;
					}
				}
			}
		}
		return answer;
	}

/**
 *  GFG question
 */

	//	Triplet Sum in Array GFG
//	Input:n = 6, x = 13, arr[] = [1,4,45,6,10,8]
//	Output: 1
//	Explanation: The triplet {1, 4, 8} in the array sums up to 13.
	/**
	 *
	 */
	public static boolean threeSum(int arr[], int result) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					if (arr[i] + arr[j] + arr[k] == result) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/** Optimzed way to use the hashMap
	 *
	 */
	public static boolean optimizedthreeSum(int arr[], int result) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			Map<Integer,Integer> map= new HashMap<>();
			for(int j=i+1;j<len;j++) {
				if(map.containsKey(result-arr[i]-arr[j])) {
					return true;
				}else {
					map.put(arr[j], 1);
				}
			}
		}
		return false;
	}
	

}
