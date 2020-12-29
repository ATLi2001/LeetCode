import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    // Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> out = new ArrayList<>();

        if (root == null)
            return out;

        pathSumHelper(root, sum, new ArrayList<>(), out);

        return out;
    }

    // helper function
    // sum is remaining sum after subtracting off each node
    // path is a potential path to add to overall
    private static void pathSumHelper(TreeNode curr, int sum, List<Integer> path, List<List<Integer>> overall){
        // stop condition
        if(curr == null){
            return;
        }

        // subtract off current value
        int target = sum - curr.val;
        // add to path
//        List<Integer> currPath = new ArrayList<>(path);
//        currPath.add(curr.val);
        path.add(curr.val);

        // check if curr is a leaf
        if(curr.left == null && curr.right == null){
            if(target == 0){
//                overall.add(currPath);
                overall.add(new ArrayList<>(path));
            }
        }

        // recursion
//        pathSumHelper(curr.left, target, currPath, overall);
//        pathSumHelper(curr.right, target, currPath, overall);
        pathSumHelper(curr.left, target, path, overall);
        pathSumHelper(curr.right, target, path, overall);
        // backtrack
        path.remove(path.size() - 1);
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
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        List<List<Integer>> paths = pathSum(node0, 22);

        // expected
        // [ 5 4 11 2 ]
        // [ 5 8 4 5 ]
        for(List<Integer> list : paths){
            System.out.print("[ ");
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.print("]");
            System.out.println();
        }

    }
}
