package programs.linkedlist;
import java.util.Stack;
import org.graalvm.collections.Pair;

public class PalindromeLinkedList {

    public static void main(String[] args) {


//        Input: LinkedList: 1->2->1->1->2->1
//        Output: true
//        Explanation: The given linked list is 1->2->1->1->2->1 ,
//                which is a palindrome and Hence, the output is true.

        PalindromeLinkedList list = new PalindromeLinkedList();

        // Creating the list: 1->2->1->1->2->1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        System.out.println("Original List:");
        list.printList(head);
        System.out.println("\nAfter adding 1:");
        boolean result = list.isPalindromeOptimal(head);
        System.out.println(result);
    }
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }






    /**
     * A- simple apporach
     * 1- use the stack and store all the elemnet into stack
     * 2- second step pop the elemnt from stack and compare with
     * linkedList if not match then return false otherwise true
     * Time complexity O(N) and Space complexity O(N) because the stack
     * */
   public static  boolean isPalindrome(Node head) {
        // Create a new linked list to store the reversed linked list
      Stack<Node> stack = new Stack<>();
      Node temp = head;
      // push in the stack
      while (temp!= null) {
          stack.push(temp);
          temp = temp.next;
      }
      // compare from both ends of the reversed linked list
       Node curr = head;
       while (curr!= null) {
           if (curr.data!= stack.pop().data) {
               return false;
           }
           curr = curr.next;
       }
       return true;

    }

    /**
     * 1- use the slow fast pointer to cal the mid
     * 2- second half linkedList reverse and return the newHead
     * 3- take the 2 pointer first = head amd second = newHead
     * 4- compare both until not reach the second!=null first!=newHead
     * 5- if any of element not match then return false
     * 6- when complete the compartion returns true
     */
    public static  boolean isPalindromeOptimal(Node head) {

        // Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            // Move the slow pointer one step ahead
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half of the linked list
        Node secondhalf = reverseLinkedList(slow.next);

        // take 2 pointers first second
        Node first = head;
        Node second = secondhalf;
        // compare both until not reach the second!=null first!=newHead
        while (second != null && first != secondhalf) {
            if (first.data != second.data) {
                reverseLinkedList(slow.next);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedList(slow.next);
        return true;


    }


        public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            //update the next
            next = current.next;
            // update current.next
            current.next = prev;
            // move to prev
            prev = current;
            // move to current
            current = next;
        }
        return prev;
    }
}
