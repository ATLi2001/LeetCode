import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return null;

        List<List<Integer>> out = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // track the depths of the nodes
        Queue<Integer> depth = new LinkedList<>();
        depth.add(0);

        // current depth list
        List<Integer> temp = new ArrayList<>();
        int prevDepth = 0;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int currDepth = depth.poll();
            // same temp list
            if(currDepth == prevDepth)
                temp.add(curr.val);
            // new temp list
            else {
                out.add(temp);
                temp = new ArrayList<>();
                temp.add(curr.val);
            }

            if(curr.left != null){
                queue.add(curr.left);
                depth.add(currDepth+1);
            }
            if(curr.right != null){
                queue.add(curr.right);
                depth.add(currDepth+1);
            }

            prevDepth = currDepth;
        }
        // last depth may not have been added
        if(!temp.isEmpty())
            out.add(temp);

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
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        List<List<Integer>> levelorder = levelOrder(node0);
        // expected
        // 1
        // 2 3
        // 4 5 6 7
        for(int i = 0; i < levelorder.size(); i++){
            for(int j = 0; j < levelorder.get(i).size(); j++){
                System.out.print(levelorder.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
