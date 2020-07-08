package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A124二叉树的最大路径和p
 * @Author : Richard.Wu
 * @Date: 2020-06-21 09:38
 * @Description :
 */

public class A124二叉树的最大路径和p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {

        if(root==null)return 0;

        getMathPath(root);

        return maxValue;
    }

    int maxValue = Integer.MIN_VALUE;

    private int getMathPath(TreeNode current) {

        int leftMax = 0, rightMax = 0;

        int value = current.val;

        if (current.left != null) {
            leftMax = getMathPath(current.left);
        }
        if (current.right != null) {
            rightMax = getMathPath(current.right);
        }

        value += (leftMax > 0 ? leftMax : 0) + (rightMax > 0 ? rightMax : 0);
        maxValue = Math.max(maxValue, value);

        return current.val + Math.max(leftMax > 0 ? leftMax : 0,
                rightMax > 0 ? rightMax : 0);

    }


}
