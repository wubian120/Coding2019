package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A222完全二叉树的节点个数p
 * @Author : Richard.Wu
 * @Date: 2020-04-11 17:57
 * @Description :
 */

public class A222完全二叉树的节点个数p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int countNodes(TreeNode root) {

        return root!=null?countNodes(root.left)+
                countNodes(root.right)+1:0;

    }
}
