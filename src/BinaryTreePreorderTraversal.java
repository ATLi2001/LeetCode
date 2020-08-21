import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

//    // recursive solution
//    private static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> out = new ArrayList<>();
//        preorderHelper(root, out);
//        return out;
//    }
//    // recursive helper function
//    private static void preorderHelper(TreeNode x, List<Integer> out){
//        if(x == null)
//            return;
//        out.add(x.val);
//        preorderHelper(x.left, out);
//        preorderHelper(x.right, out);
//    }

    // iterative solution
    private static List<Integer> preorderTraversal(TreeNode root){
        if(root == null)
            return new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            out.add(curr.val);
            // want to do left before right in preorder so add right to stack first
            if(curr.right != null)
                stack.add(curr.right);
            if(curr.left != null)
                stack.add(curr.left);
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

        List<Integer> preorder = preorderTraversal(node0);
        // expected 1 2 4 5 3 6 7
        for(Integer i : preorder){
            System.out.print(i + " ");
        }
    }
}
