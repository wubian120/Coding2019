package cn.bw.leetcode.sample;

/**
 * @ClassName : A124二叉树中的最大路径和s
 * @Author : Richard.Wu
 * @Date: 2020-06-21 09:08
 * @Description :
 */

public class A124二叉树中的最大路径和s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        getMaxPath(root);
        return maxValue;
    }

    int maxValue = Integer.MIN_VALUE;

    private int getMaxPath(TreeNode current) {
        int leftMax = 0, rightMax = 0;
        int value = current.val;

        if (current.left != null) {
            leftMax = getMaxPath(current.left);
        }
        if (current.right != null) {
            rightMax = getMaxPath(current.right);
        }

        value += (leftMax > 0 ? leftMax : 0) + (rightMax > 0 ? rightMax : 0);
        if (value > maxValue) {
            maxValue = value;
        }

        return current.val + Math.max((leftMax > 0 ? leftMax : 0), (rightMax > 0 ? rightMax : 0));
    }


}
