import common.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal {

//    // recursive solution
//    private static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> out = new ArrayList<>();
//        inorderHelper(root, out);
//        return out;
//    }
//
//    private static void inorderHelper(TreeNode x, List<Integer> out){
//        if(x == null)
//            return;
//
//        inorderHelper(x.left, out);
//        out.add(x.val);
//        inorderHelper(x.right, out);
//    }

    // iterative solution
    private static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        // track visited tree nodes
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            visited.add(curr);
            // only add the value if nothing on the left to do
            if(curr.left == null || visited.contains(curr.left)) {
                out.add(curr.val);
            }
            else{
                // since is a stack, add right, current, and then left so they get done in reverse order
                if(curr.right != null && !visited.contains(curr.right))
                    stack.push(curr.right);
                stack.push(curr);
                if(curr.left != null && !visited.contains(curr.left))
                    stack.push(curr.left);
            }
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

        List<Integer> inorder = inorderTraversal(node0);
        // expected 4 2 5 1 6 3 7
        for(Integer i : inorder){
            System.out.print(i + " ");
        }
    }
}
