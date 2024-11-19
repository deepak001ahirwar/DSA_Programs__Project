package programs.tree;

public class PredecessorSuccessorBST {

    public static void main(String[] args) {


        //       Predecessor and Successor
        Node root = new Node(8);  // Root node
        root.left = new Node(1);    // Left child of root
        root.right = new Node(9);   // Right child of root
        root.left.right = new Node(4);  // Right child of 1
        root.left.right.left = new Node(3);  // Left child of 4
        root.right.right = new Node(10);
        Node[] pre = new Node[0];
        Node[] suc = new Node[0];
        findPreSuc(root, pre, suc, 1);
    }

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        suc = successor(root, suc, key);
        System.out.println("suc: " + suc[0].data);

    }
    public static Node predecessor(Node root, Node pre, int key) {

        return null;
    }

    public static Node[] successor(Node root, Node [] suc, int key) {
        while (root != null) {
            if (key >= root.data) {
                root = root.right;
            } else {
                suc = new Node[]{root};
                root = root.left;
            }
        }
        return suc;
    }
}
