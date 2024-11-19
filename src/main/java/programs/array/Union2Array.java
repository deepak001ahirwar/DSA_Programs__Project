package programs.array;
import java.util.HashSet;
import java.util.Set;

public class Union2Array {

	public static void main(String[] args) {

//		Input:
//			5 3
//			1 2 3 4 5
//			1 2 3
//			Output: 
//			5
//			Explanation: 
//			1, 2, 3, 4 and 5 are the
//			elements which comes in the union set
//			of both arrays. So count is 5.
		
		//Apporach -1
		// used frequescy array
		// [0,0,0,0,0,0,0,]
		// [0,1,2,3,4,5,6] index
		// itrate  the array and update the freq array count
		// after that count the non zero element in freq array
			
		//Apporach -2 
		//use set and print size of set 
		int arrA[]= {1, 2, 3, 4, 5};
		int arrB[]= {1, 2, 3};		
		Set<Integer> setdata= new HashSet<Integer>();		
		for(Integer s1:arrA) {
			setdata.add(s1);
		}		
		for(Integer s2:arrB) {
			setdata.add(s2);
		}		
		System.out.println(setdata.size());
		System.out.println(setdata.toString());
		// time o(m+n)
		// space O(M+N)
	}

}
