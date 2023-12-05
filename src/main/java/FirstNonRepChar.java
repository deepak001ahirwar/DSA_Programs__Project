import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepChar {

	public static void main(String[] args) {
		/**
		 * Input: “geeksforgeeks”
		 *  Output: f Explanation: As ‘f’ is first character in
		 * the string which does not repeat.
		 **/

		/**
		 * Apprach-1 1- use the first and last 
		 * index of char the return -1;
		 *  Apprach-2 
		 *  1- use map to first store the freq and char
		 *  2- return if the first value is 1
		 */

		String str="algorithm";
		System.out.println("str: "+str);
		System.out.println("nonreptChar: "+nonreptChar(str));
	}

	public static char nonreptChar(String str) {
		int len = str.length();
		// 1 use index of 
		for (int i = 0; i < len; i++) {
			if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
				return str.charAt(i);
			}
		}
		
		
		// 2 use map 
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		System.out.println("Map: " + map.toString());
		for (Map.Entry<Character, Integer> data : map.entrySet()) {
			if (data.getValue() == 1) {
				System.out.println("Key : " + data.getKey());
				return data.getKey();
			}
		}
		// using java 8
		String firstNonRept = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey()
				.toString();			
		System.out.println("firstNonRept: "+firstNonRept);		
		return '$';
	}

}
