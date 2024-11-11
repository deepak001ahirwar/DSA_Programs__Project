package programs.linkedlist;
public class CheckCircularLL {


    public static void main(String[] args) {


//        Check If Circular Linked List
//                I/p= 2->4->6->7->5( 5 ->2 )
//        Output: true
//        Explanation: As shown in figure the first and last node is connected, i.e. 5 --> 2

        CheckCircularLL list = new CheckCircularLL();

        // Creating the list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(0);
        head.next = new Node(5);
//        head.next.next = new Node(6);
//        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(4);
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        list.printList(head);
        System.out.println("\nAfter adding 1:");
        boolean circular = list.isCircular(head);
        System.out.println(" circular: "+circular);
    }
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    boolean isCircular(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Your code here
        java.util.Map<Node, Integer> map = new java.util.HashMap<>();

        Node temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            } else {
                map.put(temp, 1);
                temp = temp.next;
            }
        }
        return false;

    }
    }
