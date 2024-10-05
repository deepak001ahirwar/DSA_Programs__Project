package programs.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintAnagramsTogether {

    public static void main(String[] args) {
//Print Anagrams Together (GFG)
//        N = 5
//        words[] = {act,god,cat,dog,tac}
//        Output:
//        act cat tac
//        god dog
//        Explanation:
//        There are 2 groups of
//        anagrams "god", "dog" make group 1.
//        "act", "cat", "tac" make group 2.
        String[] string_list = {"act", "god", "cat", "dog", "tac"};
        System.out.println("printAnagramsTogether: " + printAnagramsTogether(string_list));
//        printAnagramsTogether(string_list);
    }

    /**
     * 1- use the hashing
     * 2- itrate the string array
     * 3- use the Map<String,List<String>> maplist
     * 4- sort the element of String array
     * 5- check if the exits in maplist then put the acutal elemnt without sorted
     * 6- else put the sorted element as key and value is sorted  elments
     * 7- return the maplist values only
     */
    private static List<List<String>> printAnagramsTogether(String[] stringList) {
        Map<String, List<String>> maplist = new HashMap<String, List<String>>();
        for (String str : stringList) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (maplist.containsKey(sortedStr)) {
                List<String> savedList = maplist.get(sortedStr);
                savedList.add(str);
                maplist.put(sortedStr, savedList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                maplist.put(sortedStr, newList);
            }
            // alternative way
//            maplist.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
            String str2 = String.valueOf("".charAt(0));

        }
        System.out.println("maplist: " + maplist);
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : maplist.values()) {
            result.add(list);
        }
//        List<List<String>> result =  maplist.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
//       return Collections.singletonList(maplist.values().toString());
        return result;
    }
}
