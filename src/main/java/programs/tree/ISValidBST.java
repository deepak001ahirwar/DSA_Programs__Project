package programs.tree;

public class ISValidBST {


    public static void main(String[] args) {

//        Check for BST
    }

    boolean isBST(Node root) {
        // code here.

        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        // check for BST
        if(root.data<=min||root.data>=max){
            return false;
        }
        // call recursive and update the for left ( max is root.data) and right ( min is root.data)
        return isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max);

    }

}
