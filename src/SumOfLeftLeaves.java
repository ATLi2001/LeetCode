import common.TreeNode;

public class SumOfLeftLeaves {

    private static int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;

        int sum = 0;
        if(root.left != null){
            // make sure left is leaf
            if(root.left.left == null && root.left.right == null)
                sum += root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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

        // expected 20
        System.out.println(sumOfLeftLeaves(node0));
    }
}
