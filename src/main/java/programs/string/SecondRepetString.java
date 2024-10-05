package programs.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SecondRepetString {


    public static void main(String[] args) {

//        Input:
//        N = 6
//        arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
//        Output: bbb
//        Explanation: "bbb" is the second most
//        occurring string with frequency 2.
        String[] arr = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        System.out.println("findSecondMostFrequent " + findSecondMostFrequent(arr));
    }

    private static String findSecondMostFrequent(String[] arr) {
        // Create a frequency map to store the frequency of each string
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
        Arrays.stream(arr).forEach(feq -> {
            frequencyMap.put(feq, frequencyMap.getOrDefault(feq, 0) + 1);
        });
        List<Map.Entry<String, Integer>> map = new ArrayList<>(frequencyMap.entrySet());
        //map.stream().sorted(Map.Entry.comparingByValue());
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        Optional<String> result = sortedMap.entrySet().stream().skip(1).findFirst().map(x -> x.getKey());
        List<String> resultList = new ArrayList<>(sortedMap.keySet());
        return new ArrayList<>(sortedMap.keySet()).get(1);
    }
}
