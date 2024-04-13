package programs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramtwoString {

	public static void main(String[] args) {

		String s1 = "basgadhbfgvhads";
		String s2 = "sjdhgvbjdsbhvbvd";

//		swalrl  lsrasw
//		geeksforgeeks forgeeksgeeks

		// anagram means the same char in other string
		// only sequence is diff

		System.out.println("isAnagram: " + isAnagram(s1, s2));
		
		
		
		// 2 -How do you find the minimum number of characters to
		//		be deleted to make two strings anagrams?

	}

	public static boolean isAnagram(String a, String b) {

		if (a.length() == 0 || b.length() == 0) {
			return false;
		}

//		if (!(a.length() == b.length())) {
//			return false;
//		}
//		Apporach-1 
//		for (int i = 0; i < s1.length(); i++) {
//			if (!s2.contains(String.valueOf(s1.charAt(i)))) {
//				return false;
//			}
//		}
//		
		// Approach-2
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < a.length(); i++) {
			if (map.containsKey(String.valueOf(a.charAt(i)))) {
				map.put(String.valueOf(a.charAt(i)), (map.get(String.valueOf(a.charAt(i))) + 1));
			} else {
				map.put(String.valueOf(a.charAt(i)), 1);
			}
		}
		System.out.println("Map Data: " + map.toString());
		// store
		for (int i = 0; i < b.length(); i++) {
			if (map.containsKey(String.valueOf(b.charAt(i)))) {
				map.put(String.valueOf(b.charAt(i)), (map.get(String.valueOf(b.charAt(i))) - 1));
			} else {
				map.put(String.valueOf(b.charAt(i)), 1);
			}
		}

		System.out.println("FinalMap: " + map.toString());
		for (Integer tem : map.values()) {
			if (tem != 0) {
				return false;
			}
		}
		// Apporach -3 use frequency array
		int freqArr[] = new int[26];
		for (int i = 0; i < a.length(); i++) {
			freqArr[a.charAt(i) - 'a'] = freqArr[a.charAt(i) - 'a'] + 1;
		}
		System.out.println("freqArray: " + Arrays.toString(freqArr));

		for (int i = 0; i < b.length(); i++) {
			freqArr[b.charAt(i) - 'a'] = freqArr[b.charAt(i) - 'a'] - 1;
		}
		System.out.println("Final freqArray: " + Arrays.toString(freqArr));
		for (int k = 0; k < freqArr.length; k++) {
			if (freqArr[k] != 0) {
				return false;
			}
//			Math.abs(k)
		}
		return true;
	}

}
