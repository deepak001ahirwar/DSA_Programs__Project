package programs.tree;

import java.util.ArrayList;

public class CountBSTRange {
    public static void main(String[] args) {
        // Count the number of BSTs with keys in the given range
//        Input:
//                 10
//                /  \
//              5    50
//              /    /  \
//            1    40  100
//        l = 5, h = 45
//        Output: 3
//        Explanation: 5 10 40 are the node in the
//                range
    }

    public int getCount(Node root, int l, int h) {
        //Your code here
        ArrayList<Integer> ls = new ArrayList<>();
        inOrder(root, ls);
        return getCountNumber(ls, l, h);
    }

    public int getCountNumber(ArrayList<Integer> ls, int l, int h) {
        int count = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i) >= l && ls.get(i) <= h) {
                count++;
            }
        }
        return count;
    }

    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

    }
}
