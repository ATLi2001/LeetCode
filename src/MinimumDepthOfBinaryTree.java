import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    // The minimum depth is the number of nodes along the shortest path
    // from the root node down to the nearest leaf node.
    private static int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        // use level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()){
            // get all nodes on the current level
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                // leaf node
                if(curr.left == null && curr.right == null)
                    return depth;
                // otherwise add next level nodes
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            depth++;
        }

        return depth;
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
        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        node5.right = node6;

        // expected 2
        System.out.println(minDepth(node0));
    }
}
