package cn.bw.leetcode.sample;

/**
 * @ClassName : A226翻转二叉树s
 * @Author : Richard.Wu
 * @Date: 2020-04-07 10:23
 * @Description :
 *
 * 递归解法
 *  2020-04-07
 *
 */

public class A226翻转二叉树s {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public TreeNode invertTree(TreeNode root) {

        if(root==null)return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;

    }


}
