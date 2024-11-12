package programs.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class HeightBinaryTree {
    public static void main(String[] args) {


    }

    /**
     * 1 -  simple way breath search Appoarch
     * 2- use the Queue to store the root into qe
     * 3- itrare the loop untill qe is not empty
     * 4- store the size of qe into temp
     * 5- itrate the while loop until temp >0
     * 6- poll the data of qe and store in curr
     * 7- check if the curr.right!=null add the curr.right into qe
     * 8- check if the curr.left!=null add the curr.left into   qe
     * 9- temp--
     * 10 - out side the inner while loop height++; and return the height
     */
    public static int height(Node root) {
        // code here
        Queue<Node> qe = new LinkedList<>();
        int height = 0;
        qe.add(root);
        while (!qe.isEmpty()) {
            int temp = qe.size();
            while (temp > 0) {
                Node curr = qe.poll();
                if (curr.right != null) {
                    qe.add(curr.right);
                }
                if (curr.left != null) {
                    qe.add(curr.left);
                }
                temp--;
            }
            height++;
        }
        return height;
    }

    /**
     *  1 - height use the rescurrsion algorithm
     *  2-  call the max(height(root.left) , height(root.right))+1
     *  3-  we did the +1 for current node added
     */
    public static int heightRecurrsion(Node root) {
        if (root==null) return 0;
        return Math.max(heightRecurrsion(root.left),heightRecurrsion(root.right))+1;

    }

    }
