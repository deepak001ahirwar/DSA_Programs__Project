package programs.searchingSorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueEqualToIndex {

    public static void main(String[] args) {

//        Value equal to index value
//        Input: arr[] = [15, 2, 45, 4 , 7]
//        Output: 2 , 4
//        Explanation:
//        Here, arr[2] = 2 exists here.
//        and arr[4] = 4 exists here.
//        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 45, 4, 7)) ;
        List<Integer> arr = new ArrayList<>(List.of(5, 2, 45, 4, 7)) ;
        System.out.println( "arr: "+arr);
        List<Integer> result = findValueEqualToIndex(arr);
        System.out.println("result: " + result);
    }

    private static List<Integer> findValueEqualToIndex(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        int index =1;
        for(Integer res : arr) {
            if(res==index){
                result.add(index);
            }
            index++;
        }
        return result;
    }
}
