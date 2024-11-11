package programs;
import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

		// GFG
//		Explanation: After merging both the array's and sorting it with get the desired output.
		int nums1[] = {1, 2, 3};
		int nums2[] = {2, 5, 6};
		// output : {1, 2,2, 3,5,6}
//		mergeSortedArrayWithSpace(nums1, nums2);
		mergeSortedArrayWith3Pointer();
	}
    	// useing extra space and 2 pointer apporach

	/**
	 * 1- take the third array of size (arr1.length+arr2.length)
	 * 2- take 2 pointer i=0, j=0 for itrate the both arrays
	 * 3- inside the while loop condition i<n && j<m
	 * 4- check if the arr1[i] is lesser than arr2[j] the put the arr1[i] into arr3[k] , i++, k++
	 * 5- else part put the arr2[j] into arr[k] , j++,k++
	 * 6- outside the while loop condition check the remaning elements of arr1 while (i<n) arr[i] into the arr[k] i++, k++
	 * 7- same we do for arr2  remaning elements of arr2 while (j<m) arr[j] into the arr[k] j++, k++
	 *
	 */
		public  static  int []  mergeSortedArrayWithSpace(int nums1 [],int nums2[]){
			int m=nums1.length;;
			int n=nums2.length;
			int arr3 [] = new int[m+n];
			int i=0,j=0,k=0;
			while(i<m&&j<n){
				if(nums1[i]<nums2[j]){
					arr3[k]=nums1[i];
					i++;
				}else{
					arr3[k]=nums2[j];
					j++;
				}
				k++;
			}
			// reaming elemnt of arr1
			while(i<m){
				arr3[k]=nums1[i];
				k++;
				i++;
			}
			// remaing elemnt array2
			while(j<n){
				arr3[k]=nums2[j];
				j++;
				k++;
			}
			System.out.println(Arrays.toString(arr3));
			return arr3;
		}

      //. Merge Sorted Array leetcode questions
    	// 2 - Apporach 3 pointer
    	/**
    	 * Input: nums1 = [1,2,3,0,0,0],
    	 *  m = 3, 
    	 *  nums2 = [2,5,6], n = 3
			Output: [1,2,2,3,5,6]
			Explanation: The arrays we are merging are [1,2,3]
		 	and [2,5,6].
		 The result of the merge is [1,2,2,3,5,6] with
		 the underlined elements coming from nums1.
    	 * 
    	 */

		public static void mergeSortedArrayWith3Pointer(){
			int arr1[]= {1,2,3,0,0,0};
			int arr2[]= {2,5,6};
			int m=3; // no of element in arr1
			int n=3; // no of element in arr2

			System.out.println("first Arr: "+Arrays.toString(arr1));
			System.out.println("second Arr: "+Arrays.toString(arr2));

			int i=m-1; // compare pointer
			int j=arr1.length-1; // use for put at the index
			int k=n-1; // use for compare pointer

			// for second array size
			while(k>=0) {
				if(i>=0&&arr1[i]>arr2[k]) {
					arr1[j]=arr1[i];
					i--;
				}else {
					arr1[j]=arr2[k];
					k--;
				}
				j--;
			}

			System.out.println("Finals Arrays :"+Arrays.toString(arr1));
		}

}