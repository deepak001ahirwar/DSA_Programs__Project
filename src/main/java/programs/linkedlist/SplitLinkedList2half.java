package programs.linkedlist;
import org.graalvm.collections.Pair;

public class SplitLinkedList2half {


    public static void main(String[] args) {

//        Given a Circular linked list. The task is split into two Circular Linked lists
//        Input: LinkedList : 10->4->9
//        Output: 10->4 , 9

        SplitLinkedList2half list = new SplitLinkedList2half();

        // Creating the list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(699);
        head.next = new Node(841);
        head.next.next = new Node(793);
        head.next.next.next = new Node(293);
        head.next.next.next.next = new Node(232);
        head.next.next.next.next.next = new Node(725);
        Node lastNode = new Node(359);
        head.next.next.next.next.next.next = lastNode;
        lastNode.next = head;
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
//        list.printList(head);
        System.out.println("\nAfter adding 1:");
//        Node result = list.addOne(head);
        Pair<Node, Node> result = list.splitList(head);
        list.printList(result.getLeft());
        list.printList(result.getRight());

    }
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }



    public Pair<Node, Node> splitCircularList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node firstHalf = head;
        Node secondHalf = slow.next;

        // check if even number of Node then move the fast at last node
        if (fast.next.next == head) {
            fast = fast.next;
        }
        // Make the second half circular
        fast.next = slow.next;
        //make the first half circular
        slow.next = head;
        // Return the pair of lists
        return Pair.create(firstHalf, secondHalf);
    }


    /**
     *
     * this split in linerar linedlist
     */

    public Pair<Node, Node> splitList(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast.next!= head && fast.next.next!= head) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node secondHalf = slow.next;
        slow.next = null;

        if(fast.next==head){
            fast.next=null;
        }else{
            fast.next.next=null;
        }
        return Pair.create(head,secondHalf);
    }
    }
