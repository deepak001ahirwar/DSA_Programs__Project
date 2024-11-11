package programs.linkedlist;
public class DeletionCircularLL {

    public static void main(String[] args) {


//        Deletion and Reverse in Circular Linked List
//        Input: Linked List: 2->5->7->8->10, key = 8
//
//        Output: 10->7->5->2
//        Explanation: After deleting 8 from the given circular linked list,
//        it has elements as 2, 5, 7, 10. Now, reversing this list will result in 10, 7, 5, 2 &
//                the resultant list is also circular


    }
    Node deleteNode(Node head, int key) {
        // code here

        // base case
        if(head==null) return null;
        Node curr = head.next;
        Node prev = head;
        // delete the first  node from the linked list
        if( curr== head&&curr.data==key){
            head = null;
            return head;
        }
        // delete the last node from the linked list
        if(curr.data==key){

        }

        // delete any node from the linked list

return null;

    }

}
