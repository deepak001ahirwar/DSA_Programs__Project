package programs.tree;

public class MirrorBinaryTree {
    public static void main(String[] args) {
//        Create a mirror tree from the given binary tree
//        Input:
//                 2
//                / \
//               1   8
//                /     \
//                12      9
//        Output:
//        Inorder of original tree: 12 1 2 8 9
//        Inorder of mirror tree: 9 8 2 1 12

        Node tree = createNode(5);
        tree.left = createNode(3);
        tree.right = createNode(6);
        tree.left.left = createNode(2);
        tree.left.right = createNode(4);
        System.out.print("Inorder of original tree: ");
        inOrder(tree);

        // Function call
        mirrorTree(tree);

        System.out.print("\nInorder of mirror tree: ");
        inOrder(tree);    }

    /**
     *1- use the resuresion
     * 2- base condtion is if the root is null then null
     * 2- call then mirrorTree(root.left) and store into new node left
     * 3- call the mirrorTree(root.right) and store into new node right
     * 4- simply swap the left with root.right
     * 5- swap right with root.left
     * 6-return root
     */
    public static Node mirrorTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);
            root.right = left;
        root.left = right;
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }
    public  static Node createNode(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }
}
