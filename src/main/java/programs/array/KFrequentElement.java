package programs.array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KFrequentElement {

	public static void main(String[] args) {

		int arr[] = {};
		//4,1,-1,2,-1,2,3
		int k = 2;
		
		int finalArry[] = new int[k];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		System.out.println(map.toString());

//		Map<Integer, Integer> sortedMap = sortByValueHashMap(map);
		Map<Integer, Integer> sortedMap = map;
		System.out.println("HashMAp After sorting \n ");
		System.out.println(sortedMap);

        	
		
		List<Map.Entry<Integer,Integer>> entryset= new ArrayList<>(map.entrySet());
		entryset.sort((a, b) -> {
			// sort base on the key 
			if (a.getValue() == b.getValue())
				return b.getKey() - a.getKey();
			else
				// sort on the value
				return b.getValue() - a.getValue();
		});
		

				System.out.println("HashMAp After sorting \n ");
				System.out.println(entryset);

		        	
				int j=0;

				for(int i=0;i<k;i++){

					finalArry[j]=entryset.get(i).getKey();
					j++;
				}
//		for(Integer newsortedMap : sortedMap.keySet()) {
//			if(k>j) {
//			System.out.println(newsortedMap);
//			finalArry[j]=newsortedMap;
//			j++;
//			}
//		}
		
//		for (Map.Entry<Integer, Integer> newsortedMap : sortedMap.entrySet()) {
//			if (k > j) {
//				finalArry[j] = newsortedMap.getKey();
//				j++;
//			}
//		}
        
        System.out.println("finalArry "+Arrays.toString(finalArry));

	}

	public static HashMap<Integer, Integer> sortByValueHashMap(HashMap<Integer, Integer> map) {
		// first store in list
		List<Entry<Integer, Integer>> list = new LinkedList(map.entrySet());
		// sort in reverse order
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		HashMap sortedMap = new HashMap();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Map.Entry entry = (Entry) itr.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;

	}

	public  void kFrequentElement(){
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k=2;
		// correct Apporach to solve th top k frequency problem
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int num : nums) {
			map2.put(num, map2.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue()
		);
		pq.addAll(map2.entrySet());
		List<Integer> result3 = new ArrayList<>();
		while (k-- > 0) {
			result3.add(pq.poll().getKey());
		}
		System.out.println(":result3 "+result3 );
	}

}
