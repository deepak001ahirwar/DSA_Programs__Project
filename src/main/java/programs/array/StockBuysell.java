package programs.array;
import java.util.Arrays;

public class StockBuysell {

	public static void main(String[] args) {

		
		
		/**Input: prices = [7,1,5,3,6,4]
				Output: 5
				Explanation: Buy on day 2 (price = 1) and
				 sell on day 5 (price = 6), profit = 6-1 = 5.
				Note that buying on day 2 and selling on 
				day 1 is not allowed because you must buy before you sell.
				Ex**/
		int arr[]= {7,1,5,3,6,4};
		
		System.out.println("Arrays: "+Arrays.toString(arr));
		System.out.println("Maxproft: "+maxProfit(arr));
		
	}
public static  int maxProfit(int[] prices) {
        
        /***
        Approach 1-
        // using two loop compare the store the max profit
        // and return if profit -ve 0
        // not run all test cases 
         */
    int MaxProfit=Integer.MIN_VALUE;
    // int buy=0;
    // int sell=0;
    int len=prices.length;
    // for(int i=0;i<len;i++){
    //     for(int j=i+1;j<len;j++){
    //         // sell - buy
    //         int max=prices[j]-prices[i];
    //         if(max>MaxProfit){
    //             MaxProfit=max;
    //         }
    //     }
    // }
    // if(MaxProfit>0){
    //     return MaxProfit;
    // }
    // return 0;



    //Approach -2
    /**
    1- use 0 index  value as minvalue for buy assuming 
    2- or check and itrate the next elemnt is minvalue the replcae minvalue
    3- otherwise calculate maxprofit sell-buy        
     */

    int buy=prices[0];
    for(int i=1;i<len;i++){

        if(buy>prices[i]){
            buy=prices[i];
        }else if( prices[i]-buy>MaxProfit){
            MaxProfit=prices[i]-buy;
        }
    }
    if(MaxProfit>0){
        return MaxProfit;
    }
    return 0;

    }
}
