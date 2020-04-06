package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A104二叉树的最大深度p
 * @Author : Richard.Wu
 * @Date: 2020-02-21 13:03
 * @Description :
 * <p>
 * 1.2020-02-21
 * 2.2020-02-23
 */

public class A104二叉树的最大深度p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }


    }

}
