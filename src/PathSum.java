import common.TreeNode;

public class PathSum {

    // Given a binary tree and a sum, determine if the tree has a root-to-leaf path
    // such that adding up all the values along the path equals the given sum.
    private static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        int nextSum = sum - root.val;

        // leaf
        if(root.left == null && root.right == null){
            if(nextSum == 0)
                return true;
        }

        // recursion
        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;

        // expected true
        System.out.println(hasPathSum(node0, 22));
        // expected false
        System.out.println(hasPathSum(node0, 100));
    }
}
