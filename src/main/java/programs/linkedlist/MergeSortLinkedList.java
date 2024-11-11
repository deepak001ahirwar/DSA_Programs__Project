package programs.linkedlist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSortLinkedList {


    public static void main(String[] args) {

        Map<Node,Integer> map = new HashMap<>();
//        Merge Sort for Linked List
//        Input: LinkedList: 3->5->2->4->1
//        Output: 1->2->3->4->5
//        Explanation: After sorting the given linked list, the resultant matrix will be 1->2->3->4->5.


    }


    /**
     * 1- first divided linkedList into two half the apply merge
     * 2-take 3 pointer , slow , fast, prev = head
     * 3- iterate the while loop until the fast!=null and fast.next!=null
     * 4- update prev = slow, slow with slow.next and fast with fast.next.next
     * 5- when complete the loop prev.next=null so got linkedlist into two half
     * 6- call the sortListOptimal(head) recursively for left and right sub list sortListOptimal(slow)
     * 7- call the merge(left,right) and retur
     * 8- inside the merge function create the dummy Node -1 make is head
     * 9- create the tail = head
     * 10- itrate the while loop until the left!=null and right!=null
     * 11- compare the left.data <= right.data then saved into ansHead.next = new Node(left.data)
     *  and update the left = left.next
     * 12 - else part for saved the ansHead.next=new Node(right.data)
     * and update the right = right.next
     * 13- out side the if else upate the andHead=ansHead.next
     * 14- fill the reaming elements of the left and right linkedlist
     * 15- remove the first dummy node from ansHead and return the ansHead
     */
    public Node sortListOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        Node prev = head;
        //split the linkedlist into two half the apply merge
        while (fast!= null && fast.next!= null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // split the list and make the previous next as null
        // Mrege the left sub LL and the right
        Node left = sortListOptimal(head);
        Node right = sortListOptimal(slow);
        Node result = merge(left, right);
        return result;
    }

    private Node merge(Node left, Node right) {
        Node ansHead = new Node(-1);
        Node ansTail = ansHead;
        while(left!=null && right!=null){
            // compare if left node elements is smaller than
            // add the left one otherwise right one
            if(left.data<=right.data){
                ansTail.next = new Node(left.data);
                left = left.next;
            }else{
                ansTail.next = new Node(right.data);
                right = right.next;
            }
            ansTail= ansTail.next;
        }
        // remaining elements of left node
        while(left!=null){
            ansTail.next = new Node(left.data);
            left = left.next;
            ansTail= ansTail.next;
        }

        // remaining elements of right node
        while (right!=null){
            ansTail.next = new Node(right.data);
            right = right.next;
            ansTail= ansTail.next;
        }

        // remove the dummy -1 Node move to next node
        // and first node to null
        Node temp = ansHead;
        ansHead = ansHead.next;
        temp.next = null;
        return ansHead;
    }


    //// optimal with afficent time complexity


    private Node mid(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node mergeSort(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    public Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = mid(head);
        Node newnode = mid.next;
        mid.next = null;
        Node lefthalf = sortList(head);
        Node righthalf = sortList(newnode);
        return mergeSort(lefthalf, righthalf);
    }







    /**
     * A- simple Apporch
     * 1- first store the linkedList into the array
     * 2- apply merge sort on the array
     * 3- create the new LinkedList with the sorted array
     *  Time limit issue occurs
     */
    public   static Node mergeSortLL(Node head) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Node temp = head;
        while (temp!=null){
            list.add(temp.data);
            temp = temp.next;
        }

        int arr[] =list.stream().mapToInt(Integer::intValue).toArray();
        int l = 0;
        int r = arr.length - 1;
        int[] sortedArray = mergeSort(arr, l, r);
        Node result = makeLinkedList(sortedArray, head);
        return result;
    }

    private static Node makeLinkedList(int[] sortedArray,Node head) {
        Node temp = head;
        int index=0;
       while (temp != null) {
            temp.data = sortedArray[index];
            temp = temp.next;
            index++;
       }
       return head;
    }

    private static int [] mergeSort(int[] arr , int l , int r) {
        if(l<r) {
            int mid=(l+r)/2;
            System.out.println("L: "+l+" "+" mid: "+mid+"r: "+r);
            // divide into half
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            //call the merge for merging
            merge(arr,l,mid,r);
        }
        return arr;

    }
    public  static void merge(int[] arr, int l, int mid, int r) {
        System.out.println(" inside merge fun: l "+l+" mid: "+mid+" r: "+ r );
        // Find sizes of two subarrays to be merged

        // cal the size of array is upperlimit -lowerlimit +1
        int n1=mid-l+1;  // for upper limit mid and lower limit l
        int n2=r-mid;    // we did not add 1 plues due to already added

        int tempA[]= new int[n1];
        int tempB[]= new int[n2];

        System.out.println("before copy data: "+Arrays.toString(arr));
        //copy data into temp array
        // from start l+i
        for(int i=0;i<n1;i++) {
            tempA[i]=arr[l+i];
        }
        for(int j=0;j<n2;j++) {
            tempB[j]=arr[mid+1+j];    // mid+1+j
        }
        System.out.println("tempA: "+Arrays.toString(tempA));
        System.out.println("tempB: "+Arrays.toString(tempB));

        // star sorting the tempA and tempB
        // Initial indices of first and second subarrays
        int i=0,j=0;

        // Initial index of merged subarray array
        int k = l;

//        int count=0;
        while(i<n1&&j<n2){
            // put small ele into array
            if(tempA[i]<=tempB[j]) {
                arr[k]=tempA[i];
                i++;
            }
            // inversion required and need to swap
            else {
                arr[k]=tempB[j];
//        		count=count+((mid+1)-(l+i));
                j++;
            }
            k++;
        }
        System.out.println("in merge count: ");

        // Copy remaining elements of 2 temp arr if any
        while(i<n1) {
            arr[k]=tempA[i];
            k++;
            i++;
        }
        while(j<n2) {
            arr[k]=tempB[j];
            k++;
            j++;
        }
        System.out.println("after copyelment: "+Arrays.toString(arr));
    }
}
