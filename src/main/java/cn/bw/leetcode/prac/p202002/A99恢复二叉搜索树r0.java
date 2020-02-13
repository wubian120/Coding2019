package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A99恢复二叉搜索树r0
 * @Author : Richard.Wu
 * @Date: 2020-02-12 23:14
 * @Description :
 */

public class A99恢复二叉搜索树r0 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    TreeNode pre = null, fst = null, snd = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        swap(fst, snd);

    }


    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (fst == null && pre.val > root.val) {
            fst = pre;
        }
        if (fst != null && pre.val > root.val) {
            snd = root;
        }
        pre = root;
        inorder(root.right);

    }

    private void swap(TreeNode a, TreeNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
}
