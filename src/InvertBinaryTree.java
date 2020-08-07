import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode invertTree(TreeNode root) {
        // stop condition
        if(root == null)
            return null;

        TreeNode leftOrig = root.left;
        TreeNode rightOrig = root.right;

        root.left = invertTree(rightOrig);
        root.right = invertTree(leftOrig);

        return root;
    }

    // print in level order traversal
    private static void printBinaryTree(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode x = q.poll();
            System.out.print(x.val + " ");
            if(x.left != null)
                q.add(x.left);
            if(x.right != null)
                q.add(x.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        // expected 4 2 7 1 3 6 9
        printBinaryTree(node0);
        System.out.println();
        // expected 4 7 2 9 6 3 1
        printBinaryTree(invertTree(node0));
    }
}
