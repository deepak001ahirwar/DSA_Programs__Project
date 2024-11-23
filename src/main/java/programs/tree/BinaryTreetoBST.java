package programs.tree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreetoBST {

    public static void main(String[] args) {



        // Convert a sorted array to a Binary Search Tree
//        Input:
//                  1
//                /   \
//               2     3
//        Output:
//        1 2 3
//        Explanation:
//        The converted BST will be
//                  2
//                /   \
//                1     3
    }

    /**
     * 1- based binary search tree
     * 2- first we calculate the inOrder of current Tree store in the ArrayList
     * 3- sort the data using the Collection.sort()
     */
    Node binaryTreeToBST(Node root) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        Collections.sort(al);
        replaceNode(root, al);
        return root;
    }

    private void replaceNode(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;
        replaceNode(root.left, al);
        root.data = al.remove(0);
        replaceNode(root.right, al);
    }

    // Helper function to find the inorder successor of a node in BST
    public static void inorder(Node node, ArrayList<Integer> al) {
        if (node == null)
            return;
        inorder(node.left, al);
        al.add(node.data);
        inorder(node.right, al);
    }


}
