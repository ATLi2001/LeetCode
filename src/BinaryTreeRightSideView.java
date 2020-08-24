import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    private static List<Integer> rightSideView(TreeNode root) {
        // use level order but only add the right most of each level

        if(root == null)
            return new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();
                if(i == levelSize - 1)
                    out.add(curr.val);

                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }

        return out;
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

        List<Integer> right = rightSideView(node0);
        // expected 1 3 5 6 7
        for(int i : right)
            System.out.print(i + " ");
    }
}
