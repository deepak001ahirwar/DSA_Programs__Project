package programs.linkedlist;
import java.util.HashSet;
import java.util.Set;

public class RemoveLoopLinkedList {

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }


        // Remove loop in Linked List

    /**
     * A- bruth forch Apporch using set
     * 1- take the set that store the node amd prev node pointer with null
     * 2- itrate the loop until the head!=null
     * 3- check if the set contains head then prev.next = null
     * 4- else add the head to set , update the prev with head and head with head.next
     */
    public static void removeLoop(Node head) {
        Set<Node> set = new HashSet<Node>();
        Node prev = null;
        while(head !=null) {
            if (set.contains(head)) {
                prev.next = null;
                return;
            } else {
                set.add(head);
                prev = head;
                head = head.next;
            }
        }
    }


    // optimal using the 2 pointer slow and fast algorithm

    /**
     * 1- first the same process to check the loop present then find the first element of loop
     * 2- then mantain the prev pointer update the prev.next = null
     * 3- take 3 pointer slow and fast with head and prev = null
     * 4- itrate the while loop until fast!=null and fast.next!=null
     * 5- update the prev=slow and slow=slow.next , fast =fast.next.next
     * 6- check if slow == fast it means loop dectected
     * 7- reach the first node where loop start and manitain prev pointer
     * 8- rest the fast = head
     * 9- itrate the while loop untill fast!= slow
     * 10- update the fast= fast.next , prev=slow , slow =slow.next
     * 11- when break the loop prev.next =null
     */
    public static void removeLoopOptimized(Node head) {

        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            // loop find
            if (slow == fast) {
                // reset the pointer to check the first element
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    prev = slow;
                    slow = slow.next;
                }
                prev.next = null;
                return;
            }
        }
    }
    }
