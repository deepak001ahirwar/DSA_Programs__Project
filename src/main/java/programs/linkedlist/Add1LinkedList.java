package programs.linkedlist;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class Add1LinkedList {


    public static void main(String[] args) {
        //    Add 1 to a Linked List Number
//    Input: LinkedList: 4->5->6
//    Output: 457

        Add1LinkedList list = new Add1LinkedList();

        // Creating the list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(9);
//        head.next = new Node(5);
//        head.next.next = new Node(6);
//        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(4);
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        list.printList(head);
        System.out.println("\nAfter adding 1:");
//        Node result = list.addOne(head);
        Node result = list.addOneRecursive(head);
        list.printList(result);
    }

    // Utility function to print the list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    /**A- Brouth forch Apporach
     * 1 - take the pointer carry =1 and head = reverse(head)
     * 2- take pointer curr = head
     * 3- itrate the loop until curr!=null update the curr.data += carray
     * 4- check if curr.data <10  update the carry=0 and break
     * 5- otherwise update  the curr.data=0 and carry=1
     * 6- outside the loop check the carry==1 then make the newNode(1)
     * 7- update the newNode.next = reverse(head) and return the newNode
     * 8 - otherwise return reverse(head)
     */
    public Node addOne(Node head) {
        int carry = 1;
        head = reverseLinkedList(head);
        Node curr = head;
        while (curr != null) {
            curr.data = curr.data + carry;
            // no need to run further
            if (curr.data < 10) {
                carry = 0;
                break;
            } else {
                curr.data = 0;
                carry = 1;
            }
            curr = curr.next;
        }
        //if carry is still 1, then there is an extra 1 at the beginning
        if (carry == 1) {
            Node newNode = new Node(1);
            Node node = reverseLinkedList(head);
            newNode.next = node;
            return newNode;
        }
        return reverseLinkedList(head);
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

    // 2- Optimal implementation with recursive solution

    /**
     * 1- call the helper Method  if the carray is 1 then create new Node and
     *  update the newnode.next = head; return the newnode otherwise return head
     * 2- insdie the helper Method  check the base condtion temp == null return 1
     * 3- call the again recusive function carray =  helper(temp.next)
     * 4- update the temp.data = temp.data+carray
     * 5- check if the temp.data <10  returns 0
     * 6- temp.data=0 returns 1
     */
    public  static Node addOneRecursive(Node head) {
        // Base case: if the head is null, return a new node with value 1
        if (head == null) {
            return head;
        }
        // Recursive case: add 1 to the value of the current node and update the carry
        int carry = helper(head);
        if(carry==1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    private  static int helper(Node temp) {
        // Base case: if the head is null, return 1
        if(temp==null){
            return 1;
        }
       int carry = helper(temp.next);
        temp.data =temp.data + carry;
        // If the current node's value is less than 10, there is no carry
        if(temp.data<10){
            return 0;
        }
        // If the current node's value is 10 or more, there is a carry
        temp.data=0;
        return 1;
    }
}