package programs.linkedlist;
public class DeleteNodesGreater {
    public static void main(String[] args) {

//        Delete nodes having greater value on right
//        Input:
//        LinkedList = 12->15->10->11->5->6->2->3
//        Output: 15->11->6->3

        DeleteNodesGreater list = new DeleteNodesGreater();

        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);

        System.out.println("Original List:");
        list.printList(head);
        System.out.println("\nAfter adding :");
        Node node = compute(head);
        list.printList(node);
    }
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }


    /**
     * A- simple implementation O(n2) algorithm
     */
    public static Node compute(Node head) {
        // your code here
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp != null) {
            boolean dropNode = false;
            Node tempNext = temp.next;
            while (tempNext != null) {
                if (tempNext.data > temp.data) {
                    dropNode = true;
                    break;
                }
                tempNext = tempNext.next;
            }
            if (dropNode) {
                head = deleteNode(head, temp);
                temp = head; //// Restart from head after deletion
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    private static Node deleteNode(Node head, Node todeleteNode) {
        // first node to be deleted
        if (head == todeleteNode) {
            return head.next;
        }
        Node current = head;
        while (current.next != todeleteNode) {
            current = current.next;
        }
        current.next = todeleteNode.next;
        return head;
    }

    /**
     * B- Optimal implementation
     * 1- reverse the linkedList
     * 3- store the maxVal =  head.data
     * 4- itrate the while loop untill the curr!=null
     * 5- check if the maxVal <= curr.data then update the prev= curr and maxVal = curr.data
     * 6- else case skip or delete the node so prev.next=curr.next
     * 7- reverse the linkedList
     */
    public static Node computeOptimized(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        // Step 1: Reverse the linked list
        head = revserse(head);

        // Step 3: Store the maxVal
        int maxVal =head.data;

        // Step 4: Iterate through the linked list
        Node prev =head;
        Node curr = head.next;
        while (curr!= null) {
            // curr is greather then update the prev and curr , maxVal
            if (curr.data >= maxVal) {
                prev = curr;
                maxVal = curr.data;
            }
            // Step 5: Delete the node
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        // Step 6: Reverse the linked list
        head = revserse(head);
        return head;
    }

    private static Node revserse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr!= null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
