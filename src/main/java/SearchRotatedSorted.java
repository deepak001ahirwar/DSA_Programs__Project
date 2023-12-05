public class SearchRotatedSorted {

	public static void main(String[] args) {

		// int [] nums={4,5,6,7,0,1,2};
		// int target =8;
		// System.out.println(search(nums, target));

		/**
		 * Approch -2 
		 * 1- first find the check the element pesent in 
		 * left sub array or
		 * right subarray 
		 * 2- then apply binary search in correct subarray
		 *  3- if present
		 * left sub array then index 0 to minindex-1
		 *  4- if present right subarray the
		 * minindex to high
		 * 
		 */
		int[] nums = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int target = 3;
		// out put index is 8

		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) / 2;

		System.out.println("Minelemnt in roted sorted array index : " + getMinimum(nums) + "  elemnt is :"
				+ nums[getMinimum(nums)]);

		if (target >= nums[getMinimum(nums)] && target <= nums[high]) {
			System.out.println(" first sub array index at : " + binarySearch(getMinimum(nums), high, target, nums));

		} else {
			System.out.println(" second subarray index at : " + binarySearch(0, getMinimum(nums) - 1, target, nums));

		}

	}

	public static int getMinimum(int arr[]) {

		// method -1
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			// it means left sub array is sorted and min value
			// in present in right sub array
			if (arr[mid] >= arr[0]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return low;

		// second way
		// int low=0;
		// int high=arr.length-1;
		// while(low<=high){
		// int mid=(low+high)/2;
		//
		//
		// // this is the last elm of sorted arry
		// if(arr[mid]>arr[mid+1]) {
		// return mid+1;
		// }
		// else if(arr[mid]<arr[mid-1]) {
		// return mid;
		// }
		// else if(arr[mid]>=arr[low]) {
		// low=mid+1;
		// }else if(arr[mid]<=arr[high]) {
		// high=mid-1;
		// }
		//
		//
		//
		// }
		// return -1;

	}

	public static int binarySearch(int low, int high, int target, int arr[]) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			}
			if (target > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static int search(int[] nums, int target) {
		/*****
		 * Approch - 
		 * 1- find the mid =()low+high)/2;
		 *  2-Then try to figure out if l to
		 * mid is sorted, or (mid+1) to h is sorted
		 *  3- divide the array into 2 sub array
		 * 4- binary search in subarray
		 */

		int low = 0;
		int len = nums.length;
		int high = len - 1;
		while (low < high) {
			// find the mid
			int mid = (low + high) / 2;
			// elemnt
			if (nums[mid] == target) {
				return mid;
			}
			// it means leftsub array is sorted and need to binarysearch
			// at leftsubarry part
			if (nums[low] <= nums[mid]) {
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// it means we need to call binary search at rightsub array
			else {
				if (target <= nums[high] && target > nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}

		return nums[low] == target ? low : -1;

	}

}
