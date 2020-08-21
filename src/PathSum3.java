import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum3 {

    private static int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;

        int count = 0;

        Queue<TreeNode> origLevelOrder = levelOrder(root);

        for(TreeNode t : origLevelOrder){
            TreeNode sums = buildSumTree(t, 0);
            Queue<TreeNode> sumsLevelOrder = levelOrder(sums);
            for(TreeNode s : sumsLevelOrder){
                if(s.val == sum)
                    count++;
            }
        }

        return count;
    }

    // from the tree at node, build a new tree of sums
    private static TreeNode buildSumTree(TreeNode root, int prevSum){
        // stop condition
        if(root == null)
            return null;

        int currVal = root.val + prevSum;
        TreeNode x = new TreeNode(currVal);
        x.left = buildSumTree(root.left, currVal);
        x.right = buildSumTree(root.right, currVal);
        return x;
    }

    // level order traversal
    private static Queue<TreeNode> levelOrder(TreeNode root){
        if(root == null)
            return new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> out = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            out.add(x);
//            System.out.print(x.val + " ");
            if(x.left != null)
                q.add(x.left);
            if(x.right != null)
                q.add(x.right);
        }
//        System.out.println();
        return(out);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;

        // expected 3
        System.out.println(pathSum(node0, 8));

    }
}
