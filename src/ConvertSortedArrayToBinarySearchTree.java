import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArrayToBinarySearchTree {

    // given sorted array nums, return a BST
    private static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    // recursive helper function
    // a[] is the overall array, lo defines the left bound, hi the right bound (both inclusive)
    private static TreeNode sortedArrayToBSTHelper(int[] a, int lo, int hi){
        // stop conditions
        if(lo > hi)
            return null;
        if(lo == hi)
            return new TreeNode(a[lo]);

        // find mid
        int mid = lo + (hi - lo)/2;
        TreeNode x = new TreeNode(a[mid]);

        x.left = sortedArrayToBSTHelper(a, lo, mid-1);
        x.right = sortedArrayToBSTHelper(a, mid+1, hi);

        return x;
    }

    // print in level order traversal
    private static void printBinaryTree(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode x = q.poll();
            System.out.print(x.val + " ");
            if(x.left != null)
                q.add(x.left);
            if(x.right != null)
                q.add(x.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        printBinaryTree(root);
    }
}
