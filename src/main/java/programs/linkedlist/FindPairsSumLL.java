package programs.linkedlist;
import java.util.ArrayList;

public class FindPairsSumLL {
    class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {


//        Find pairs with given sum in doubly linked list
//        Input:
//        1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
//        target = 7
//        Output: (1, 6), (2,5)
//        Explanation: We can see that there are two pairs
//        (1, 6) and (2,5) with sum 7.
    }

    /**
     * 1- simple Apporach use the O(n2) algorithm
     *
     * 1- first itrate the loop and
     * 2- inner loop another pointer temp2= temp.next
     * 3- if the temp.data+temp.data== target store in list
     * 4- if the temp.data+temp.data > target break the loop
     */
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DLLNode head) {
        // code here
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        DLLNode temp = head;
        while (temp!= null) {
            DLLNode temp2 = temp.next;
            while (temp2!= null) {
                // if the any pair reach greater than break the loop
                if (temp.data+temp2.data>target){
                    break;
                }
                 if(temp.data+temp2.data==target){
                     ArrayList<Integer> pair= new ArrayList<>();
                     pair.add(temp.data);
                     pair.add(temp2.data);
                     pairs.add(pair);
                 }
                 temp2 = temp2.next;
            }
            temp = temp.next;
        }
        return pairs;
    }

    /**
     * B- use the two pointer apporach as linkedlist is sorted so use the binary search algorithm
     * 1- take 2 pointer left == head and right == tail call  the last node
     * 2- itrate the loop until left.data <= right.data
     * 3- check if the left.data.right.data==target the store in list and move the
     * pointer ahead  ( left-> left.next)and( right-> right.prev)
     * 4- if the left.data.right.data < target then left ++  ( left-> left.next)
     * 5- otherwise right --  ( right-> right.prev)
     */
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumOptimal(int target, DLLNode head) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        DLLNode left = head;
        DLLNode right = getTailNode(head);
        while (left.data <= right.data) {
            if (left.data + right.data == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                pairs.add(pair);
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return pairs;
    }
    public  static DLLNode getTailNode(DLLNode head) {
        DLLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    }
