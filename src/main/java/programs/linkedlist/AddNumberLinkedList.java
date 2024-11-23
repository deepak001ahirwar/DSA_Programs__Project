package programs.linkedlist;
public class AddNumberLinkedList {

    public static void main(String[] args) {



//        Add Two Numbers (leetcode)
//        Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]

        AddNumberLinkedList list = new AddNumberLinkedList();

        // Creating the list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(3);
        // Another node L2
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

//        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(4);
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        list.printList(head);
        list.printList(head2);
        System.out.println("\nAfter adding :");
        Node node = addTwoLists(head, head2);
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
     * 1- take the 2 pointer head and temp with null , carray=0;
     * 2- itrate while loop until the l1!=null or l2!=null or carray!=0
     * 3- cal the val1 from l1.data or 0 and val2 from l2.data or 0
     * 4- sum with val1+val2+carry
     * 5- create the newNode(sum%10) with Modulers
     * 6- check if the head is null it means it is first node the make it head , temp
     * 7- else part temp.next=newNode amd update the temp=temp.next
     * 8- check if the l1!=null then update the l1=l1.next same with l2 node
     */
    public static Node addTwoLists(Node l1, Node l2) {
        Node head = null;
        Node temp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.data;
            int val2 = l2 == null ? 0 : l2.data;
            int sum = val1 + val2 + carry;
            // use the moduler to 15%10 = 5
            Node newNode = new Node(sum % 10);
            carry = sum / 10; // mantain the carry
            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }



    // Add Number Linked Lists( GFG)
//    Input: num1 = 45 (4->5->null), num2 = 345 (3->4->5->null)
//    Output:  3->9->0->null
    public static Node addTwoListsGFG(Node l1, Node l2) {
        Node head = null;
        Node temp = null;
        int carry = 0;
        // reverse the L1 and l2
        Node Rl1 = reverseLinkedList(l1);
        Node Rl2 = reverseLinkedList(l2);
        while (Rl1 != null || Rl2 != null || carry != 0) {
            int val1 = Rl1 == null ? 0 : Rl1.data;
            int val2 = Rl2 == null ? 0 : Rl2.data;
            int sum = val1 + val2 + carry;
            // use the moduler to 15%10 = 5
            Node newNode = new Node(sum % 10);
            carry = sum / 10; // mantain the carry
            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
            if (Rl1 != null) {
                Rl1 = Rl1.next;
            }
            if (Rl2 != null) {
                Rl2 = Rl2.next;
            }
        }
        return reverseLinkedList(head);
//        return head;
    }

    public  static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
