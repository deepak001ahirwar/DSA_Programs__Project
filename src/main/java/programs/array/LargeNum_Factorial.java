package programs.array;

import java.math.BigInteger;

public class LargeNum_Factorial {

	public static void main(String[] args) {

		// Find factorial of a large number

		int Num = 5;
//		BigInteger result;
//		for (int i = 1; i <= Num; i++) {
//			// result=factorial(Num);
//			result = result *(BigInteger.valueOf(i));
//		}
//		System.out.println("result: " + result);

		
		
		BigInteger f
        = new BigInteger("1"); // Or BigInteger.ONE

    // Multiply f with 2, 3, ...N
    for (int i = 2; i <= 5; i++)
        f = f.multiply(BigInteger.valueOf(i));
    
    System.out.println("Final "+f);
//		System.out.println("Recurrsive :" + factorial(5, 1));

	}

	public static int factorial(int num, int result) {
		if (num == 0) {
			return 1;
		}		 		
		return result*factorial(num - 1, result);
	}

}
