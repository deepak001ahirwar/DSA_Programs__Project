package programs.linkedlist;
import java.util.HashSet;
import java.util.Set;

public class FirstNodeloopLL {
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static void main(String[] args) {

//        Find the first node of loop in linked list
//         I/p = 1->3->2->4->5
//        Output: 3
//        Explanation:
//        We can see that there exists a loop in the given linked
//        list and the first node of the loop is 3
    }
    /**
     * 1- use the set to store the node
     * 2- itrate the loop  until curr!=null and check  if the node present in set then return the current node
     * 3- else part add the node in set and udpate  current node with current.next
     */
    public  static Node findFirstNode(Node node) {
        Set<Node> set = new HashSet<Node>();
        Node current = node;
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }

    /**
     * B- floyd's algorithm slow and fast pointer
     * 1- take 2 pointer Node slow and fast pointer
     * 2- iterate the loop until fast!=null and fast.next!=null
     * 3- update the pointer slow = slow.next and fast = fast.next.next
     * 4- check if the slow and fast at same Node it means cycles detected
     * 5-  inside the reset the slow pointer with head to check
     * 6- itrate the while loop untill the slow and fast not reach the same node
     * 7- inside the update the slow pointer and fast pointer with next node
     * 8- return the slow pointer
     */
    public static  Node findFirstNodeOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            // update the slow with 1 next and fast with 2 next
            slow = slow.next;
            fast = fast.next.next;
            // loop detected
            if (slow == fast) {
                // rest the slow pointer with head of node
                slow = head;
                while (slow != fast) {
                    // move both slow and fast pointer by 1 until they meet again
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;  // no loop found
    }
}
