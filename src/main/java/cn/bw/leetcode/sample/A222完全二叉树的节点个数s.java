package cn.bw.leetcode.sample;

/**
 * @ClassName : A222完全二叉树的节点个数s
 * @Author : Richard.Wu
 * @Date: 2020-04-09 11:21
 * @Description :
 */

public class A222完全二叉树的节点个数s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int countNodes(TreeNode root) {
        return root != null ? 1 +
                countNodes(root.right)
                + countNodes(root.left) : 0;

    }

}
