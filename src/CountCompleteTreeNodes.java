import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {

    // Given a complete binary tree, count the number of nodes
    private static int countNodes(TreeNode root) {
        // because is a complete tree, don't need to visit all nodes

        if(root == null)
            return 0;

        // find depth
        TreeNode left = root;
        int depth = 0;
        while(left != null){
            depth++;
            left = left.left;
        }

        // use level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // track which node had first null child
        int stopNode = -1;
        // was it the left or right child that was null
        boolean leftNull = true;
        while(!queue.isEmpty()){
            // number of nodes on current level
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                else{
                    stopNode = i;
                    leftNull = true;
                    break;
                }
                if(curr.right != null)
                    queue.add(curr.right);
                else{
                    stopNode = i;
                    leftNull = false;
                    break;
                }
            }
            if(stopNode != -1)
                break;
        }

        // calculate
        int count = 1;
        // case of all levels filled -> 2^depth - 1
        if(stopNode == 0 && leftNull){
            for(int i = 0; i < depth; i++){
                count *= 2;
            }
            return count - 1;
        }

        // otherwise, all levels to depth-1 are filled and then add on extras
        for(int i = 0; i < depth - 1; i++)
            count *= 2;
        count--;
        if(leftNull){
            count += stopNode * 2;
        }
        else{
            count += stopNode * 2 + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        // expected 6
        System.out.println(countNodes(node0));
    }
}
