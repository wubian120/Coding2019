package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A226翻转二叉树s;

/**
 * @ClassName : A226翻转二叉树p
 * @Author : Richard.Wu
 * @Date: 2020-04-09 08:44
 * @Description :
 */

public class A226翻转二叉树p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode left= invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }


}
