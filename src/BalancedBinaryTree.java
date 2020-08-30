import common.TreeNode;

public class BalancedBinaryTree {

    // a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
    private static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        return height(root) != -1;
    }

    // return height of tree rooted at x, or -1 if not balanced
    private static int height(TreeNode x){
        if(x == null)
            return 0;

        int left = height(x.left);
        // previously not balanced
        if(left == -1)
            return -1;
        int right = height(x.right);
        // previously not balanced
        if(right == -1)
            return -1;

        // not balanced
        if(Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
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
        node3.right = node4;
        node2.left = node5;
        node2.right = node6;

        // expected false
        System.out.println(isBalanced(node0));
    }
}
