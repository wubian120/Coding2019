package cn.bw.leetcode.sample;

/**
 * @ClassName : A104二叉树的最大深度s
 * @Author : Richard.Wu
 * @Date: 2020-02-21 12:45
 * @Description :
 */

public class A104二叉树的最大深度s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }


}
