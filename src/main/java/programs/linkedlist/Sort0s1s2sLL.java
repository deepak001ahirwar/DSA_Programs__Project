package programs.linkedlist;
public class Sort0s1s2sLL {

    public static void main(String[] args) {

//        Sort a linked list of 0s, 1s and 2s
//        Input: LinkedList: 1->2->2->1->2->0->2->2
//        Output: 0->1->1->2->2->2->2->2
//        Explanation: All the 0s are segregated to the left end of the linked list,
//                2s to the right end of the list, and 1s in between
    }
    /**
     * A- simple implementation
     * 1- cal the count of 0,1,2
     * 2- check Count0 >0 fill the data in linkedlist data 0 and Count0--
     * 3- check Count1 >1 fill the data in linkedlist data 1 and Count1--
     * 4- check Count2 >2 fill the data in linkedlist data 2 and Count2--
     */
   public  static Node segregate(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node temp = head;
        int count0 = 0,count1 = 0 ,count2 = 0;
        while (temp!= null){
            if(temp.data==0){
                count0++;
            }else if(temp.data==1){
                count1++;
            }else{
                count2++;
            }
            temp = temp.next;
        }
        Node curr = head;
        while(curr != null){
            if(count0 > 0){
                curr.data = 0;
                count0--;
            }else if(count1 > 0){
                curr.data = 1;
                count1--;
            } else{
                curr.data = 2;
                count2--;
            }
            curr = curr.next;
        }
        return head;
    }
    /**
     * B- Optimal implementation
     * 1- use the three dummy node 0,1,2 Create the linkedList
     * 2- add the node with respectected and
     * 3- at the end check the condtion if oneDummy node is null or twoDummy nodes is null
     * 4- connect it  and remove the dummyNode from
     */
    public  static Node segregateOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node temp = head;
        while (temp!= null) {
            if(temp.data==0){
                temp.next=null;
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            }else if(temp.data==1){
                temp.next=null;
                oneTail.next = temp;
                oneTail = oneTail.next;
            }else{
                temp.next=null;
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = temp.next;
        }
        // links the 0head 1head,2head
        if(oneHead.next==null){
            zeroTail.next=twoHead.next;
        }else{
            zeroTail.next=oneHead.next;
            oneTail.next=twoHead.next;
        }
        // delete the dummy node
        oneHead.next = null;
        twoHead.next = null;
        Node t1 = zeroHead;
        zeroHead = zeroHead.next;
        t1.next = null;
        return zeroHead;
    }
    }
