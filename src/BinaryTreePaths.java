import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private static List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<String> out = new ArrayList<>();

        binaryTreePathsHelper(root, out, "");

        return out;
    }

    // recursive helper function
    // add complete paths to out, prev is a string of the previously visited nodes
    private static void binaryTreePathsHelper(TreeNode x, List<String> out, String prev){
        if(x == null)
            return;

        // append x's value to prev
        String curr;
        if(prev.equals("")){
            curr = "" + x.val;
        }
        else {
            curr = prev + "->" + x.val;
        }

        // is x a leaf node
        if(x.left == null && x.right == null){
            // path is complete so add it to out
            out.add(curr);
            return;
        }

        // recursion
        binaryTreePathsHelper(x.left, out, curr);
        binaryTreePathsHelper(x.right, out, curr);
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

        List<String> paths = binaryTreePaths(node0);
        // expected
        // 5->4->11->7
        // 5->4->11->2
        // 5->8->13
        // 5->8->4->1
        for(String s : paths){
            System.out.println(s);
        }
    }
}
