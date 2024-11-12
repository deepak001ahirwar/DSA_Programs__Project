package programs.linkedlist;
import java.util.HashSet;
import java.util.Set;

public class DetectLoopLinkedlist {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {


    }

    /**
     * 1- brouth forch apporch using set
     * 2- first store all the address of linkedList in the set
     * 3- itrate the loop and first check the address of node
     * is present in the set then return true and break the loop
     * 4- else part simply store the address of node in the set and update the current with next address
     */
    public static boolean detectLoop(Node head) {

        // Create a HashSet to store addresses of nodes in the LinkedList
        Set<Node > set = new HashSet<Node>();
        // Iterate through the LinkedList
        Node curr = head;
        while(curr!=null)
        {
            if(set.contains(curr)){
                return true;
            }
            // add the node into set and update the cureent with next
            set.add(curr);
            curr=curr.next;
        }
        return false;
    }


    /**
     * 1- take the two pointer node slow and fast
     * 2- iterate the loop  with fast!=null and fast.next!=null and update the pointers with slow =slow.next ,fast =fast.next.next;
     * 3- once's it reach the position slow and fast the same node then break the loop and return true
     * 4-
     */
    public static boolean detectLoopOptimal(Node head) {
        // Floyd's Tortoise and Hare Algorithm'
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    }