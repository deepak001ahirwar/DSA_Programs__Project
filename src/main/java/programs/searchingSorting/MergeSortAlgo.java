package programs.searchingSorting;
import java.util.Arrays;

public class MergeSortAlgo {

	public static void main(String[] args) {


		/**
		 * Given array is 
		 * 12 11 13 5 6 7 
		   Sorted array is 
		   5 6 7 11 12 13 
		   in O(Nlog N)
		   
		   Approach-1
		   1- first the write the sort method
		   2- in sort find mid = (l+r)/2
		   3- use recursion function l to mid 
		   4- use second half mid+1 to r
		   5- write merge function
		   6- inside merge function take 2 temp arr and 
		   size of 2 arr
		   7- copy data into Copy data to temp arrays
		   8- Merge the temp arrays
		   9- Initial indices of first and second subarrays
		   10- swap the less and equal elemt 2 array 
		   11- remaing 2 arr data into main array 
		   12 return arr 		
		 */
		
		
		int arr[]= {13, 12,11};
		int len=arr.length-1;

		System.out.println(" before merge soted array: "+Arrays.toString(arr) );				
		sort(arr, 0, len);
		System.out.println(" After merge soted array: "+Arrays.toString(arr) );
	}
	
	public static void sort(int arr[],int l,int r) {
		if(l<r) {
			int mid=(l+r)/2;
			System.out.println("L: "+l+" "+" mid: "+mid+"r: "+r);
			// divide into half
			sort(arr,l,mid);
			sort(arr,mid+1,r);
			//call the merge for merging
			merge(arr,l,mid,r);
		}

	}

	public  static void merge(int[] arr, int l, int mid, int r) {
		System.out.println(" inside merge fun: l "+l+" mid: "+mid+" r: "+ r );
	  // Find sizes of two subarrays to be merged

		// cal the size of array is upperlimit -lowerlimit +1
		int n1=mid-l+1;  // for upper limit mid and lower limit l
		int n2=r-mid;    // we did not add 1 plues due to already added

		int tempA[]= new int[n1];
		int tempB[]= new int[n2];
		
		System.out.println("before copy data: "+Arrays.toString(arr));
		//copy data into temp array
		// from start l+i
		for(int i=0;i<n1;i++) {
			tempA[i]=arr[l+i];
		}		
		for(int j=0;j<n2;j++) {
			tempB[j]=arr[mid+1+j];    // mid+1+j
		}		
		System.out.println("tempA: "+Arrays.toString(tempA));
		System.out.println("tempB: "+Arrays.toString(tempB));
				
		// star sorting the tempA and tempB 
        // Initial indices of first and second subarrays
		int i=0,j=0;
		
        // Initial index of merged subarray array
        int k = l;
        
//        int count=0;
        while(i<n1&&j<n2){   
        	// put small ele into array
        	if(tempA[i]<=tempB[j]) {
        		arr[k]=tempA[i];
        		i++;
        	}
        	// inversion required and need to swap
        	else {
        		arr[k]=tempB[j];
//        		count=count+((mid+1)-(l+i));
        		j++;
        	}
        	k++;
        }
        System.out.println("in merge count: ");
        
        // Copy remaining elements of 2 temp arr if any
        while(i<n1) {
    		arr[k]=tempA[i];
    		k++;
    		i++;
        }
        while(j<n2) {
    		arr[k]=tempB[j];
    		k++;
    		j++;
        }
		System.out.println("after copyelment: "+Arrays.toString(arr));
	}

}
