package programs.tree;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTraversal {

    public static void main(String[] args) {
        // Create a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
//        root.right.right = new Node(7);
        /**
         *         1
         *     2      3
         *   4  5   6
         */

        System.out.println("Inorder traversal:");
//        InOrderTraversalRescursive(root);
//        InOrderTraversalIterative(root);
        System.out.println("\nPreorder traversal:");
//        PreorderTraversalRescursive(root);
        PreorderTraversalIterative(root);
//        System.out.println("\nPostorder traversal:");
//        PostorderTraversalRescursive(root);

    }
    /**
     *1- Recursive traversal
     */
    public static void InOrderTraversalRescursive(Node root){
        if(root == null){
            return;
        }
        InOrderTraversalRescursive(root.left);
        System.out.print(root.data);
        InOrderTraversalRescursive(root.right);
    }
    public static void PreorderTraversalRescursive(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data);
        PreorderTraversalRescursive(root.left);
        PreorderTraversalRescursive(root.right);
    }
    public static void PostorderTraversalRescursive(Node root){
        if(root == null){
            return;
        }
        PostorderTraversalRescursive(root.left);
        PostorderTraversalRescursive(root.right);
        System.out.print(root.data);
    }

    /**
     * Itrative way to implement
     * 1- use the stack
     * 2- itrate the while loop untill the stack is not empty or curr!=null
     * 3- check if the curr!=null then push to stack and curr update with curr.left
     * 4- else case pop the element store the curr and print the curr.data ,
     * 5- update the curr  with curr.right
     */
    public static void InOrderTraversalIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(!stack.isEmpty()||curr!= null ){
            // process the current node  push in the stack
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else{   // pop element from the stack
                curr = stack.pop();
                System.out.print(curr.data);
                curr = curr.right;
            }
        }
    }
    /**
     * 1- PreOrder Traversal use the stack and store the Node to stack
     * 2- itrate the while loop until the stack is not empty
     * 3- pop the from stack and store in curr, print the curr.data
     * 4- check the curr.right !=null push into stack curr.right
     * 5- check the curr.left !=null push into stack curr.left
     */
    public static void PreorderTraversalIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data);

            //  process the current node push in the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    /**
     * 1- POST OREDER TRAVERSAL
     * 2- use the first stack of Node type , puh root into the stack
     * 3- use another stack type Integer that use for store in curr.data
     * 4-  itrate the while loop untill stack is not empty
     * 5- pop the stack store in the curr
     * 6- push curr.data into another stack
     * 7- check if the curr.left!=null push into first stack
     * 8- check if the curr.right!=null push into first stack
     * 9- out side the while loop itrate the second stack and print the data
     */
    public static void PostorderTraversalIterative(Node root){
        Stack<Node> stack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            outputStack.push(curr.data);
            //  process the current node push in the stack
            if (curr.left!= null) {
                stack.push(curr.left);
            }
            if (curr.right!= null) {
                stack.push(curr.right);
            }
        }
        // print elements from output stack
        while (!outputStack.isEmpty()) {
            System.out.print(outputStack.pop() + " ");
        }
    }

}
