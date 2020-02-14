package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A101对称二叉树p0
 * @Author : Richard.Wu
 * @Date: 2020-02-14 23:41
 * @Description :
 */

public class A101对称二叉树p0 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;

        } else if (left != null && right != null) {

            return (left.val == right.val)
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }else {
            return false;
        }


    }


}
