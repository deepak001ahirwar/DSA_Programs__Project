import java.util.Arrays;

public class BitManipulation {

	public static void main(String[] args) {		
		
		// BitManipulation Operations 
		
		
		//1 AND &
		/* 0*0=0
		 * 0*1=0
		 * 1*0=0
		 * 1*1=1 
		 * first convert into bit 
		 * ... 16, 8, 4,2,1
		 * 
		 */
		System.out.println("& AND => 10&12");
		System.out.println(10&12);
		// output  8 
		
		// 2 OR | 
		/**
		 * 0|0=0
		 * 0|1=1
		 * 1|0=1
		 * 1|1=1 
		 */
		System.out.println("| OR => 10|12");
		System.out.println(10|12);
		// output 14
				
		// 3 Not ~ 
		/**
		 * it will revert the acual value
		 * 1 into 0 and 0 into 1
		 */		
		System.out.println("~ Not ");
		System.out.println(~1); // -2
		System.out.println(~5);// -6
		System.out.println(~6);// -7

		
		//  4 XOR ^ 
		/*If the bits are opposite, the result has a 1 in
		 *  that bit position. If they match, a 0 is 
		 *  returned.
		 * 0^0=0
		 * 1^1=0
		 * 1^0=1
		 * 0^1=1
		 */
		System.out.println("^ XOR => 10^12");
		System.out.println(10^12);// 6
		
		// 5 left shift << 
		/*
		 * Left shift: << is the left shift operator 
		 * and meets both logical and arithmetic shifts’
		 *  needs. 
		 *  multiplies `number` with 2^i times.
		 */
		System.out.println(" <<  => 7<<1");
		System.out.println(7<<1);// 14
		
		// 6 right shift  >>  divided the  `number` with 2^i times
		System.out.println(" >>  => 7>>1");
		System.out.println(7>>1); // 3
		
		/* ">>" preserves the sign, while ">>>" treats the 
		 number as an unsigned value and fills the leftmost
		 bits with zeros.
		 
		 #-> ">>>" (Unsigned Right Shift): 
		 It always fills the leftmost bits with zeros, regardless 
		 of the sign of the number.
		 
		 ">>" (Signed Right Shift):
		 If the number is positive, zeros are filled on the left.
		  If the number is negative, ones are filled on the left.
		 */
		
		
		//Question 
		// 1- check number is even or not  (use the & operater)
		// n&1==0 
		int num=11;
		System.out.println("num: "+num);
		System.out.println("Even or not => "+isNumEvenOrOdd(num));
			
		// 2-Convert characters to uppercase or lowercase
		// use XOR with a^32 so it will convert the char into 
		// upper to lower and lower to upper 
		String str="CheRrY";
		System.out.println("Original  Str: "+str);
		System.out.println("Converted Str: "+ convertCasesChar(str.toCharArray()));
		
		// 3- Write a Java program to count the number
		//of bits set to 1 (set bits) of an integer.
		// AND & 
		int nums=125;
		System.out.println(Integer.bitCount(nums));
		System.out.println("binaryCode: "+Integer.toBinaryString(nums));
		
		System.out.println("nums: "+nums);
		System.out.println("CountSetBit: "+CountSetBit(nums));
		
		// 4-Find the element in an array that is not repeated.
		// unique number XOR
		//For n numbers, the below math can be applied:
		//a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
		//		136. Single Number
		int arr[]= {4, 1, 2, 2, 1, 4, 2};
		System.out.println(Arrays.toString(arr));
		System.out.println(getUniqueNum(arr));

		
		//5- Get First Set Bit
		//Given an integer, find the position of the first
		//set-bit (1) from the right
		//Input: n = 18
		//18 in binary = 0b10010
		//Output: 2
		//use the & and << left shift to find the first 1 bit in number		
		int num2=18;
		
		
		
		
		
		
		
//		Find the missing number  (using XOR)
//		Find the first set bit using right shifting
//		Count the number of digits in an integer
//		Check if a number is a power of 2 ( using AND &)

		
		
		
	}

	public static int getFirstsetBit(int num) {
		if(num==0) {
			return 0;
		}		
		int k = 1;
		while (true) {
			if ((num & (k << (k - 1))) == 0) {
				k++;
			} else {
				return k;
			}
		}
	}
	
	
	public static int getUniqueNum(int arr[]) {
		int finalNum = 0;
		for (int nums : arr) {
			finalNum = finalNum ^ nums;
		}		
		return finalNum;		
		
	}
	
	
	
	public static int CountSetBit(int num) {
		// use the & and check the 1 bit count 	
		int count=0;
		while(num>0) {		
			num=num&num-1;
			System.out.println(num);
			count++;
		}		
		return count;	
	}
	
	
	public static String convertCasesChar(char [] ch) {
		
		// use XOR  ^ 32 for the uppercase and lowercase
		// 32 is the diff in Ascii value of letter 		
		char[] arr=new char[ch.length];
		for(int i=0;i<ch.length;i++) {			
			//ch[i]^=32;
			ch[i]=(char) (ch[i]^32);
			
		}	
		return new String(ch);		
	}
	
	
	
	
	public static boolean isNumEvenOrOdd(int num) {
		// AND operater
		if ((num & 1) == 0) {
			return true;
		}
		return false;	
	}

}
