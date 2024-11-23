package programs.linkedlist;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesLL {


    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * 1 - use the current node pointer  with head
     * 2 - check if the current.data == current.next.data is same means current and next value is same
     * 3- update the current.next with current.next.next and current.next = null
     * 4- else part simply update the current with current.next
     *
     */
    public static Node removeDuplicates(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if(current.data==current.next.data) {
                Node temp = current.next;
                current.next = current.next.next;
                temp = null; // garbage collection
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Leetcode 82. Remove Duplicates from Sorted List II
//    Input: head = [1,2,3,3,4,4,5]
//    Output: [1,2,5]

    public Node deleteDuplicates(Node head) {

        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode current = head;
        // ListNode prev = null;
        // while (current != null && current.next != null) {
        //     if(current.val==current.next.val) {
        //         int val =current.val;
        //         while(current!= null &&current.val==val){
        //              current = current.next;
        //         }
        //         if(prev!=null){
        //         prev.next = current;
        //         }else{
        //             head=current;
        //         }

        //     } else {
        //         prev = current;
        //         // prev = prev.next;
        //         current = current.next;
        //     }
        // //  current = current.next;

        // }
        // return head;

        // second better Approach
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        while (current != null && current.next != null) {
            // If current node is a duplicate
            if (current.data == current.next.data) {
                // Skip all nodes that have the same value
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                // Link prev node to the node after the last duplicate
                prev.next = current.next;
            } else {
                // No duplicate, move prev pointer
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }


    /// Remove duplicates from an unsorted linked list
//    Input: LinkedList: 5->2->2->4
//    Output: 5->2->4
//    Explanation: Given linked list elements are 5->2->2->4,
//    in which 2 is repeated only. So, we will delete the extra
//    repeated elements 2 from the linked list and the resultant
//    linked list will contain 5->2->4
    public Node removeDuplicatesUnsorted(Node head) {
        Set<Node> set = new HashSet<Node>();
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (!set.contains(current)) {
                set.add(current);
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                prev.next = current.next;
            }
        }
        return head;
    }
    }
