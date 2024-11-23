package programs.linkedlist;
import java.util.LinkedList;

public class ReverseLinkList {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    void printlist(Node list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
    }
    /**
     * 1- take the 3 pointer curr=head, next=null,prev=null;
     * 2- itrate the loop until got the null curr!=null
     * 3- update the next pointer with curr.next
     * 4- update curr.next with prev
     * 5- update the prev with curr
     * 6- update the curr with next this is the last point
     * 7- return the prev pointer
     */
    public Node reverseLinedList(Node node) {
        Node prev = null;
        Node next = null;
        Node curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
    public static void main(String[] args) {
        // Apporach-1 
        /**
         * 1- itrate the loop n/2 till 
         * 2- use 2 pointer apporach to swip the 0index and n index elelemt
         * 3- again 1 with n-1 index element 
         * 4- return the linkedlist
         *
         */
          LinkedList<Integer> linklist = new LinkedList<Integer>();
          linklist.add(1);
          linklist.add(2);
          linklist.add(3);
          linklist.add(4);
          linklist.add(5);
          System.out.println("before linkedlist "+linklist);
          System.out.println("after reverse linkedlist "+reverseLinkList2(linklist));
        //Appoarch-2 basic impl
//        ReverseLinkList list = new ReverseLinkList();
//
//        list.head = new Node(85);
//        list.head.next = new Node(15);
//        list.head.next.next = new Node(4);
//        list.head.next.next.next = new Node(20);
//        System.out.println("Given linked list");
//
//        list.printlist(head);
//
//
//        head = list.reverseLinedList(head);
//        System.out.println(" ");
//        System.out.println("after reverse ");
//        list.printlist(head);
    }
     public static LinkedList<Integer> reverseLinkList2(LinkedList<Integer> list){
        int l=0 , r = list.size()-1;
        while(l<r){
            int temp=list.get(l);
            list.set(l,list.get(r));
            list.set(r,temp);
            l++;r--;
        }
        return list;
      }
    // public static LinkedList<Integer> reverseLinkList(LinkedList<Integer> list){
    //     int len=list.size();
    //     for(int i=0;i<len/2;i++){
    //     int temp=list.get(i);
    //     // for last elemnt swap
    //     list.set(i,list.get(len-1-i));
    //     // swap 0 index value 
    //     list.set(len-1-i, temp);
    //     }
    //     return list;

    // }
    
}
