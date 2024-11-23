package programs.linkedlist;
public class IntersectionSortedLL {


    public static void main(String[] args) {


//        Intersection Sorted Linked Lists(GFG)
//        Input: LinkedList1 = 1->2->3->4->6, LinkedList2 = 2->4->6->8
//        Output: 2->4->6
//        Explanation: For the given two linked list, 2, 4 and 6 are the elements in the intersection.


        IntersectionSortedLL list = new IntersectionSortedLL();

        // Creating the list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);
        // Another node L2
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

//        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(4);
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        list.printList(head);
        list.printList(head2);
        System.out.println("\nAfter adding :");
        Node node = findIntersection(head, head2);
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
     * 1- take the two pointer temp and head to store the data
     * 2- itrate the while loop until the l1!=null or l2!=null
     * 3- check if the l1.data==l2.data inside the if condition  if this is first node like head==null
     * 4- create new node make head and temp = head
     * 5- else it means nodes already present create new Node assign to temp.next ,
     *  and update the temp with temp.next
     * 6- else if  l1.data<l2.data   then we can search in l1 right side , update l1 with l1.next
     * 7- else  update the l2 with l2.next
     */
    public static Node findIntersection(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        Node temp = null;
        Node head = null;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                return head;
            }
            if (l1.data == l2.data) {
                if (head == null) {
                    Node newNode = new Node(l1.data);
                    head = newNode;
                    temp = head;
                } else {
                    temp.next = new Node(l1.data);
                    temp = temp.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.data < l2.data) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return head;
    }
    }
