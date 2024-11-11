package programs.linkedlist;
import java.util.HashMap;
import java.util.Map;

public class IntersectionPointLL {


    public static void main(String[] args) {


//        Intersection of Two Linked Lists
//        Intersection Point in Y Shaped Linked Lists
//        Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//        Output: Intersected at '8'
    }

    /**
     * 1- use the Map to store the Node
     * 2- first linkedlist store in the Map
     * 3- when we store the Node l2 and check if the Node exits then break
     *
     */
    public static int intersectPoint(Node l1, Node l2) {
        Node temp1 = l1;
        Node temp2 = l2;
        Map<Node, Integer> map = new HashMap<>();
        // for L1 linkedList
        while (temp1 != null) {
            map.put(temp1, 1);
            temp1 = temp1.next;
        }
        // for L2 linkedList
        while (temp2 != null) {
            if (map.containsKey(temp2)) {
                return temp2.data;
            }
            temp2 = temp2.next;
        }
        return 0;
    }


    /**
     * B- use the O(1) space complexity Apporch 2 pointer
     * 1- first cal the length of the l1 and l2 linkedlist
     * 2- cal the difference of both length
     * 3- write the function collisionPoint( smaller l1 , larger l2 , diff of N2-N1) if the N1<N2
     * 4- otherwise call the CollisionPoint(larger l2,smaller l1 , N1-N2)
     * 5- inside the function we move the node to diff Count of second Node l2,
     * 6- itrate the while loop that check if the both node is same then return any l1 or l2
     *   move l1=l1.next,l2=l2.next
     */
    public static int intersectPointOptimal(Node l1, Node l2) {
        int len1 = LinkedListlength(l1);
        int len2 = LinkedListlength(l2);
        if(len1<len2){
            return collisionPoint(l1, l2, len2-len1);
        }else{
            return collisionPoint(l2, l1, len1-len2);
        }
    }

    private static int collisionPoint(Node l1, Node l2, int diff) {
        Node temp1 = l1;
        Node temp2 = l2;
        // Move the largest ll node to same position
        while (diff > 0) {
            temp2 = temp2.next;
            diff--;
        }
        // compare the l1 and l2 positions
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1.data;
    }

    private static int LinkedListlength(Node head) {
        Node temp = head;
        int length = 0;
        while (temp!= null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * C- Not search the length by itrating simple any
     * linkedList reach at the Null , point to opposite linkedList head
     * 1- if the temp1 reach at null then move to or point to head2 otherwise temp1.next
     * 2- if the temp2 reach at null then move to or point to head1 otherwise temp2.next
     **/
    public static int intersectPointOptimal2(Node l1, Node l2) {
        Node temp1=l1;
        Node temp2=l2;
        while(temp1!=temp2){
             temp1 = (temp1 == null)? l2 : temp1.next;
             temp2 = (temp2 == null)? l1 : temp2.next;
        }
        return temp1.data;
    }

        class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


}


