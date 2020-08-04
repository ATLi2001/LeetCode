import java.util.Stack;

public class SymmetricTree {

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

    // recursive function to add left side nodes
    private static void leftTraverse(Stack<TreeNode> stack, TreeNode x){
        // stop condition
        if(x == null){
            stack.push(null);
            return;
        }

        // add x, go left then right
        stack.push(x);
        leftTraverse(stack, x.left);
        leftTraverse(stack, x.right);
    }

    // recursive function to add right side nodes
    private static void rightTraverse(Stack<TreeNode> stack, TreeNode x){
        // stop condition
        if(x == null){
            stack.push(null);
            return;
        }

        // add x, go right then left
        stack.push(x);
        rightTraverse(stack, x.right);
        rightTraverse(stack, x.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        // track the nodes on either side
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();

        // symmetrically add in the nodes on the left and right
        leftTraverse(left, root.left);
        rightTraverse(right, root.right);

        // now see if the stacks are equal
        if(left.size() != right.size())
            return false;

        while(!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.pop();
            TreeNode r = right.pop();
            if(l == null && r == null)
                continue;
            else if(l == null || r == null)
                return false;
            else
                if (l.val != r.val)
                    return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        // expected true
        System.out.println(isSymmetric(node0));

        node1.left = null;
        node2.left = null;
        node4.val = 3;
        // expected false
        System.out.println(isSymmetric(node0));
    }
}
