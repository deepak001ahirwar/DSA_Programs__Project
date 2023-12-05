public class MaximumWordsProblem {



    public static void main(String[] args) {
        
    	
    	
    	/**
    	 * 
    	 * 
    	 * Input: sentences = ["alice and bob love leetcode",
    	 *  "i think so too",
    	 *  "this is great thanks very much"]
			Output: 6
			Explanation: 
			- The first sentence, "alice and bob love leetcode",
			 has 5 words in total.
			- The second sentence, "i think so too", 
			has 4 words in total.
			- The third sentence, "this is great thanks very much",
			 has 6 words in total.
				Thus, the maximum number of words in a single sentence comes from the third sentence,
				 which has 6 words.
    	 */
    	
        //2114. Maximum Number of Words Found in Sentences
		String[] sentences = { "alice and bob love leetcode",
				"i think so too",
				"this is great thanks very much" };
		int max = 0;
		for (String data : sentences) {
			int count = 0;
			String arr[] = data.split(" ");
			count = arr.length;
			max = Math.max(max, count);
		}



    }
    
}
