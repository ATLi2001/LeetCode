import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

//    // recursive solution
//    private static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> out = new ArrayList<>();
//        postorderHelper(root, out);
//        return out;
//    }
//
//    private static void postorderHelper(TreeNode x, List<Integer> out){
//        if(x == null)
//            return;
//        postorderHelper(x.left, out);
//        postorderHelper(x.right, out);
//        out.add(x.val);
//    }

    // iterative solution
    private static List<Integer> postorderTraversal(TreeNode root){
        if(root == null)
            return new ArrayList<>();

        // to return
        List<Integer> out = new ArrayList<>();
        // for postorder use stack to record values
        Stack<Integer> outStack = new Stack<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            // in postorder, left will come before right
            // but since putting onto outStack and then out, need to put left before right
            if(curr.left != null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);
            outStack.push(curr.val);
        }

        // put values into out which is a list
        while(!outStack.isEmpty()){
            out.add(outStack.pop());
        }

        return out;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        List<Integer> postorder = postorderTraversal(node0);
        // expected 4 5 2 6 7 3 1
        for(Integer i : postorder){
            System.out.print(i + " ");
        }
    }
}
