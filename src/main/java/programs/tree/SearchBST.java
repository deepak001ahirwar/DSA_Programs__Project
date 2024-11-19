package programs.tree;

public class SearchBST {

    public static void main(String[] args) {

        //Search a node in BST
//        Input:         2
//                        \
//                        81
//                       /    \
//                      42      87
//                       \       \
//                       66      90
//                     /
//                   45
//        X = 87
//        Output: 1
//        Explanation: As 87 is present in the
//        given nodes , so the output will be
//        1.


        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        System.out.println( "--------------------------------");
//        System.out.println("Search 55: " + search(root, 55));
//        System.out.println("Search 19: " + search(root, 19));
        System.out.println("Search 66: " + searchIterative(root, 66));
        System.out.println("Search 20: " + searchIterative(root, 20));
    }

    /**
     * 1- Recursive search in BST tree
     * 2- base case the if curr==null returns null
     * 3- check if the curr.data == target then return true
     * 4- check if the curr.data > target update the curr = curr.left
     * 5- else case the  curr = curr.right
     */
   public static   boolean search(Node root, int x) {
       if (root == null) {
           return false;
       }
       if (root.data == x) {
           return true;
       }
       if (root.data > x) {
           return search(root.left, x);
       } else {
           return search(root.right, x);
       }
   }

    /**
     * B- Iterative way to search the BST
     * 1- check the current is null return false
     * 2- itrate the  while loop untill the curr!=null
     * 3- check if the curr.data == target then return true
     * 4- check curr.data> target the update the curr= curr.left
     * 5- else case the curr = curr.right
     *
     */
    public static   boolean searchIterative(Node root, int x) {
        if(root == null){
            return false;
        }
        Node curr = root;
        while (curr!= null) {
            if (curr.data == x) {
                return true;
            }
            if (curr.data > x) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }

}
