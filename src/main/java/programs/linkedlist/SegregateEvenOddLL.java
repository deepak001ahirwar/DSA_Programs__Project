package programs.linkedlist;
public class SegregateEvenOddLL {
    public static void main(String[] args) {


//        Segregate even and odd nodes in a Linked List
//        Input: Linked list: 17->15->8->9->2->4->6
//        Output: 8->2->4->6->17->15->9
        AddNumberLinkedList list = new AddNumberLinkedList();

        // Creating the list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);

        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        list.printList(head);
        System.out.println("\nAfter adding :");
        Node node = divide(head);
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
     * A- use the 2 dummy Node  even and odd
     * 1- connect the node with even if the vale is even
     * 2- connect the node with odd if the vale is odd
     * 3- at the end connect the even next with odd head
     *
     */
    public static  Node divide(Node head) {
        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node evenHead = even;
        Node oddHead = odd;
        Node curr =head;
        // connect the even data node with even and odd data nodes with odd
        while (curr!= null) {
            if(curr.data%2==0){
                even.next=curr;
                even = even.next;
            }else{
                odd.next=curr;
                odd = odd.next;
            }
            curr = curr.next;
        }

        // Now connect the even.next with odd head;
        odd.next = null;

        even.next = oddHead.next;

        oddHead.next = null;
        return evenHead.next;



    }








        // this will not cover the case where
  public static  Node divide2(Node head) {
      // code here
      if (head == null || head.next == null) {
          return head;
      }
      Node curr = head;
      while (curr != null) {
          Node nextNode = curr.next;
          while (nextNode != null) {
              if (nextNode.data % 2 == 0) {
                  int temp = curr.data;
                  curr.data = nextNode.data;
                  nextNode.data = temp;
                  break;
              }
              nextNode = nextNode.next;
          }
          curr = curr.next;
      }
      return head;
  }
}
