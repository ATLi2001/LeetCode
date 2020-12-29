import common.TreeNode;

public class SumRootToLeafNumbers {

    // Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    // An example is the root-to-leaf path 1->2->3 which represents the number 123.
    // Find the total sum of all root-to-leaf numbers.
    private static int sumNumbers(TreeNode root) {
        int out = 0;

        if(root == null)
            return out;

        return sumNumbersHelper(root, out);
    }

    private static int sumNumbersHelper(TreeNode curr, int prevSum){
        // stop condition
        if(curr == null){
            return 0;
        }

        // going from 12 to 123 is equivalent to
        // 123 = 12 * 10 + 3

        int currSum = prevSum * 10 + curr.val;

        // leaf
        if(curr.left == null && curr.right == null){
            return currSum;
        }

        // recursion
        return sumNumbersHelper(curr.left, currSum) + sumNumbersHelper(curr.right, currSum);

    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);

        node0.left = node1;
        // expected 49
        System.out.println(sumNumbers(node0));

        node0.right = node2;
        node1.left = node3;
        node1.right = node4;

        // expected 1026
        System.out.println(sumNumbers(node0));
    }
}
