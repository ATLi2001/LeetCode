package common;
// Definition for a binary tree node.
public class TreeNode {
    // make sure variables have general access
    public int val;
    public TreeNode left;
    public TreeNode right;
    // three constructors
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
