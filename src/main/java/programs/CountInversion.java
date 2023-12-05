package programs;
import java.util.Arrays;

public class CountInversion {

	public static void main(String[] args) {


		/*
		 * Input: N = 5, arr[] = {2, 4, 1, 3, 5}
		Output: 3
	   Explanation: The sequence 2, 4, 1, 3, 5 
		has three inversions (2, 1), (4, 1), (4, 3).
		 * 
		 * Apporach- 1
		 * 1- use 2 pointer i and j  . i=0,j=i+1
		 * 2- compare arr[i] and arr[j]
		 * 3- if arr[i]> arr[j] then count ++;
		 * 4- change the i when j reach at end 
		 * 
		 */		
		int [] arr= {2, 4, 1, 3, 5};
		int max= Integer.MIN_VALUE;
		
//		System.out.println("InversionCount: " + getInversionCount(arr, arr.length));
		
		System.out.println("Inversion using mergesort: "+sort(arr,0,arr.length-1));
	}	
	public static int getInversionCount(int arr[],int N) {	
		long startT=System.currentTimeMillis();
        int count=0;
		int i=0;
        int j=i+1;
        while(i<j&&j<N){
        	System.out.println("i :"+arr[i]+" "+"j: "+arr[j]);
            if(arr[i]>arr[j]){
               count++; 
            }
            // it means j at last index
            if(j==N-1){
                i++;
                j=i+1;
            }else {
                j++;
            }                      
        }       
        System.out.println("Count : "+count);
		long endT=System.currentTimeMillis();
		long totaltime=endT-startT;
		System.out.println("Total time taken- : "+totaltime+" milliseconds");
		
		return count;
		
		
		
	}
	
	public static int sort(int arr[],int l,int r) {
		int count=0;
		if(l<r) {
			int mid=(l+r)/2;
			System.out.println("L: "+l+" "+" mid: "+mid+"r: "+r);

			// divide into half
			int L_count=sort(arr,l,mid);
			int R_count=sort(arr,mid+1,r);
			
			//call the merge for merging			
			int M_count=merge(arr,l,mid,r);
			System.out.println("L_count: " + L_count + " " + "R_count:"
					+ " " + R_count + " M_count: " + M_count);
			return L_count+R_count+M_count;
		}
		return count;
		
	}

	public  static int merge(int[] arr, int l, int mid, int r) {

		System.out.println(" inside merge fun: l "+l+" mid: "+mid+" r: "+ r );
	  // Find sizes of two subarrays to be merged
		
		int n1=mid-l+1;
		int n2=r-mid;
		
		
		int tempA[]= new int[n1];
		int tempB[]= new int[n2];
		
		System.out.println("before copy data: "+Arrays.toString(arr));
		//copy data into temp array 
		for(int i=0;i<n1;i++) {
			tempA[i]=arr[l+i];
		}		
		for(int j=0;j<n2;j++) {
			tempB[j]=arr[mid+1+j];
		}		
		System.out.println("tempA: "+Arrays.toString(tempA));
		
		System.out.println("tempB: "+Arrays.toString(tempB));
				
		// star sorting the tempA and tempB 
        // Initial indices of first and second subarrays
		int i=0,j=0;
		
        // Initial index of merged subarray array
        int k = l;
        
        int count=0;
        while(i<n1&&j<n2){   
        	// put small ele into array
        	if(tempA[i]<=tempB[j]) {
        		arr[k]=tempA[i];
        		i++;
        	}
        	// inversion required and need to swap
        	else {
        		arr[k]=tempB[j];
//        		count+=(mid-i);
        		//(m + 1) - (l + i)
        		count+=(mid + 1) - (l + i);
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
	
		return count;
	}

}
