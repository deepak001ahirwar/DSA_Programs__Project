package programs.linkedlist;
public class ReverseDoublyLinkedList {

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

    }

    // Method to reverse a doubly linked list
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if (head == null || head.next == null) {
            return head;
        }
        DLLNode temp = null;
        DLLNode current = head;
        while (current != null) {
            // Swap the next and prev pointers
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Move to the next node in the original list
            current = current.prev;
        }
        // update the head with the
        head = temp.prev;
        return head;

    }
}
