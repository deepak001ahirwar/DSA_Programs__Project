package programs.tree;

public class MinimumMaxBST {

    public static void main(String[] args) {


    }

    /**
     * 1- itrate the  curr to left until reach the null
     * 2- at the end reach the minimum
     */
    public static int minValue(Node root) {
        if (root == null) {
            return 0;
        }
        Node curr = root;
        while (curr.left !=null) {
                curr = curr.left;
        }
        return curr.data;

    }

    /**
     * 1- itrate the curr to right until reach the null
     * 2- at the end reach the maximum
     *
     */
    public static int maxValue(Node root) {
        if (root == null) {
            return 0;
        }
        Node curr = root;
        while (curr.right!=null) {
                curr = curr.right;
        }
        return curr.data;

    }

}