package programs;
import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {        
        
    	// useing extra space and 2 pointer apporach
    	
    /*	int nums1[]={1,2,3};
        int nums2 []={2,5,6};
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
         while(i<m){
            arr3[k]=nums1[i];
            k++;
            i++;
         }
         while(j<n){
            arr3[k]=nums2[j];
            j++;
            k++;
         }
         System.out.println(Arrays.toString(arr3));
        */

         
    	// 2 Apporach 3 pointer 
    	/*
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
    	
    	int arr1[]= {1,2,3,5,0,0,0};
    	int arr2[]= {2,5,6};
    	int m=4; // no of element in arr1 
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