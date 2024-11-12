package programs.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
class Node {
    int data;
    Node left, right;

    Node() {
    }

    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class ReverseLevelOrderTraversal {



    public static void main(String[] args) {

    }

    /** Simple Apporach
     * 1 - use the  Queue to store the Node
     * 2- first store the root in the qe
     * 3- itrate the while loop untill the qe is empty
     * 4-  poll the curr Node from qe and store in the list
     * 5- check if the curr.right is not null then store it on the queue
     * 6- check if the curr.left is not null then store it on the queue
     * 7- reverse it the list and return it
     */
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> qe = new LinkedList<>();
        qe.add(root);
        while (!qe.isEmpty()) {
            Node curr = qe.poll();
            list.add(curr.data);
            if (curr.right != null) {
                qe.add(curr.right);
            }
            if (curr.left != null) {
                qe.add(curr.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
