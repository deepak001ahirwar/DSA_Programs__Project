package programs.tree;

import java.util.ArrayList;

public class KthLargestBST {
    public static void main(String[] args) {
        // Find the kth largest node in a BST
    }
    public int kthLargest(Node root, int k) {
        // Your code here

        if(root==null){
            return -1;
        }
        ArrayList<Integer> preOrderList = new ArrayList<>();
        inOrder(root, preOrderList);
        return preOrderList.get(preOrderList.size()-k);


    }
    public static  void  inOrder(Node root, ArrayList<Integer> ls){
        if(root==null){
            return;
        }
        inOrder(root.left,ls);
        ls.add(root.data);

        inOrder(root.right,ls);

    }
}
