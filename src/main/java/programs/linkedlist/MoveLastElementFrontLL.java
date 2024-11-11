package programs.linkedlist;
public class MoveLastElementFrontLL {
    public static void main(String[] args) {
//        Move Last Element to Front of a Linked List
//        Input: Linked List: 2->5->6->2->1
//        Output: 1->2->5->6->2
    }

    /**
     * 1- take the 2 pointer curr=head, prev=null
     * 2- itrate the loop until curr.next!=null till reach the last element
     * 3- oinside the loop update the prev with curr and curr with curr.next
     * 4- outeside the loop prev.next==null  and curr.next=head , head==curr
     */
    public static Node moveToFront(Node head) {
        // Base case: if head is null or head.next is null, return head
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        // Traverse the list to find the last node
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        // Move the last node to the front
        prev.next = null;
        curr.next = head;
        head = curr;
        return head;

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
