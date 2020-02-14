package cn.bw.leetcode.sample;

/**
 * @ClassName : A101对称二叉树s
 * @Author : Richard.Wu
 * @Date: 2020-02-14 11:30
 * @Description :
 */

public class A101对称二叉树s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) return false;

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }
}
