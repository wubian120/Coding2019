package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A100p1
 * @Author : Richard.Wu
 * @Date: 2020-02-14 23:29
 * @Description :
 */

public class A100p1 {
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
                return isSameTree(p.left, q.left) &&
                        isSameTree(p.right, q.right);
            }else {
                return false;
            }

        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }

}


