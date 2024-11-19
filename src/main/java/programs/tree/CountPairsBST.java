package programs.tree;

import java.util.ArrayList;

public class CountPairsBST {
    public static void main(String[] args) {
//        Brothers From Different Roots
//        Input:
//        BST1:
//                 5
//                /   \
//               3     7
//                / \   / \
//               2   4 6   8
//
//        BST2:
//                 10
//                /    \
//               6      15
//                / \    /  \
//               3   8  11   18
//        x = 16
//        Output:
//        3
//        Explanation:
//        The pairs are: (5, 11), (6, 10) and (8, 8)
        int x = 16;
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
    }

    /**
     * 1- first cal the InOrder of both BST and store in List
     * 2- itrate the loop untill first list has elemnt and check
     * 3- if the (target - list.get(i)) present in second Array count++
     */
    public static int countPairs(Node root1, Node root2, int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(root1, list);
        ArrayList<Integer> list2 = new ArrayList<>();
        inOrder(root2, list2);

        return countPairsBST(list, list2, x);
    }

    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static int countPairsBST(ArrayList<Integer> list, ArrayList<Integer> list2, int x) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int target = x - list.get(i);
            if (binarySearch(list2, target))
                count++;
        }
        return count;
    }

    public static boolean binarySearch(ArrayList<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == target)
                return true;
            if (list.get(mid) < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
