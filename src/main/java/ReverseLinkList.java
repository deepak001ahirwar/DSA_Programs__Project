import java.util.LinkedList;

public class ReverseLinkList {

        static Node head;
        static class Node{
            int data;
            Node next;
            Node(int d){
                data=d;
                next=null;
            }

        }

        void printlist(Node list){
            while(list!=null){
                System.out.print(list.data+" ");
                list=list.next;
            }
        }


        public Node reverseLinedList(Node node){

            Node prev=null;
            Node next=null;
            Node curr=node;

            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
               node=prev;

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

        //  LinkedList<Integer> linklist = new LinkedList<Integer>();
        //  linklist.add(1);
        //  linklist.add(2);
        //  linklist.add(3);
        //  linklist.add(4);
        //  linklist.add(5);
        //  System.out.println("before linkedlist "+linklist);
        //  System.out.println("after reverse linkedlist "+reverseLinkList(linklist));        

        //Appoarch-2 basic impl 
        
        ReverseLinkList list =new ReverseLinkList();

        list.head=new Node(85);
        list.head.next= new Node(15);
        list.head.next.next= new Node(4);
        list.head.next.next.next= new Node(20);
        System.out.println("Given linked list");

        list.printlist(head);


        head=list.reverseLinedList(head);
        System.out.println(" ");
        System.out.println("after reverse ");
        list.printlist(head);




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
