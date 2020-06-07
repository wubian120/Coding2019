package cn.bw.leetcode.sample;

/**
 * @ClassName : A617合并二叉树s
 * @Author : Richard.Wu
 * @Date: 2020-06-06 18:41
 * @Description :
 */

public class A617合并二叉树s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归解法
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }





}
