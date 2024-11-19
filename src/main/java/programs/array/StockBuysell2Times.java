package programs.array;

import java.util.Arrays;

public class StockBuysell2Times {

	public static void main(String[] args) {
//		int arr[]= {10, 22, 5, 75, 65, 80};
//		2,30,15,10,8,25,80
		int arr[]= {2, 30, 15, 10, 8, 25, 80};
		int n=arr.length;
		int temp=arr[n-1];
        for(int i=n-2;i>=0;i--){          
            arr[i+1]=arr[i];           
        }
        arr[0]=temp;
        
//		int arr[]= {2, 30, 15, 10, 8, 25, 80};
		System.out.println("maxProfit2timesTrade: "+maxProfit2timesTrade(arr));
		
		// Apprach- 
		/**1- we can solve the problrm in two part
		 * 2- inlize the temparr to store the maxprofit 
		 * 3- first part start from end and store the maxprofit in new array. sell-price[i],temparr[i+1]  
		 * 4- in second part calculate the max profit using buy temparr[i-1], (price[i]-buy)+temparr[i]
		 * 
		 */

	}

	public static int maxProfit2timesTrade(int price[]) {
		int n = price.length;
		int temparr[] = new int[n];
		Arrays.fill(temparr, 0);
		int sell = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (sell < price[i]) {
				sell = price[i];
			}
			temparr[i] = Math.max(temparr[i + 1], (sell-price[i]));
		}
		// first buy sell	
		int buy=price[0];
		for (int j = 1; j < n; j++) {
			if (buy > price[j]) {
				buy = price[j];
			}
			temparr[j] = Math.max(temparr[j - 1], temparr[j] + (price[j]-buy));
		}
		
		return temparr[n-1];
		
		
		
//		int MaxProfit = Integer.MIN_VALUE;
//		int SecMaxProfit = Integer.MIN_VALUE;
//		int buy = arr[0];

//		int SbuyIndex=0;
//		// itrate the array and calculate the max profit and secondProfit
//		for (int i = 1; i < len; i++) {
//			System.out.println("profit: "+(arr[i]-buy));
//			if (buy > arr[i]) {
//				buy = arr[i];
//				SbuyIndex=i;
//			} else if (arr[i]-buy > MaxProfit) {
////				SecMaxProfit = MaxProfit;
//				MaxProfit = arr[i]-buy;
//			}
////			else if ( arr[i]-buy > SecMaxProfit && SecMaxProfit < MaxProfit) {
////				SecMaxProfit = arr[i]- buy ;
////			}
//		}
//		System.out.println(" buy: "+buy);
//		int Secbuy = arr[0];
//		for(int i=1;i<SbuyIndex;i++) {
//			if (Secbuy > arr[i]) {
//				Secbuy = arr[i];
//			} else if (arr[i]-Secbuy > SecMaxProfit) {
////				SecMaxProfit = MaxProfit;
//				SecMaxProfit = arr[i]-Secbuy;				
//			}
//		}
//		System.out.println(" MaxProfit: "+MaxProfit+" "+"SecMaxProfit: "+SecMaxProfit);
//		if (MaxProfit + SecMaxProfit > 0) {
//			return MaxProfit + SecMaxProfit;
//		}
//		return 0;

	}
	public static int maxProfitntimesTrade(int prices[]) {
	 int profit = 0;
     for(int i=1;i<prices.length;i++) {
         if(prices[i] > prices[i-1]) {
             profit += prices[i] - prices[i-1];
         }
     }
     return profit; 
	}
}
