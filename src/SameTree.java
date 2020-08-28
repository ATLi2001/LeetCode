import common.TreeNode;

public class SameTree {

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        // use recursion

        if(p == null && q == null){
            return true;
        }
        else if(p == null && q != null){
            return false;
        }
        else if(p != null && q == null){
            return false;
        }
        else {
            // same val
            if(p.val == q.val){
                // check left and right subtrees
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            else{
                return false;
            }
        }

    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        node11.left = node12;
        node11.right = node13;

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        node21.left = node22;
        node21.right = node23;

        // expected true
        System.out.println(isSameTree(node11, node21));

        TreeNode node31 = new TreeNode(1);
        TreeNode node32 = new TreeNode(2);
        node31.left = node32;

        TreeNode node41 = new TreeNode(1);
        TreeNode node42 = new TreeNode(2);
        node41.right = node42;

        // expected false
        System.out.println(isSameTree(node31, node41));
    }
}
