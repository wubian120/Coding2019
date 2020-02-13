package cn.bw.leetcode.sample;

/**
 * @ClassName : A100相同的树s
 * @Author : Richard.Wu
 * @Date: 2020-02-13 11:20
 * @Description :
 */

public class A100相同的树s {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        } else {
            return true;
        }


    }
}
