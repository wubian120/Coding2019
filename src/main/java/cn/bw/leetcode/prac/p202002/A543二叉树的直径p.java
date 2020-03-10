package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A543二叉树的直径p
 * @Author : Richard.Wu
 * @Date: 2020-03-10 09:57
 * @Description :
 */

public class A543二叉树的直径p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int result=0;
    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return result;

    }

    private int depth(TreeNode node){
        if(node==null)return 0;

        int left=depth(node.left);
        int right = depth(node.right);

        result = Math.max(result, right+left);
        return Math.max(right,left)+1;
    }

}
