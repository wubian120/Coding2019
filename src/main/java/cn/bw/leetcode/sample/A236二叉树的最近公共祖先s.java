package cn.bw.leetcode.sample;

/**
 * @ClassName : A236二叉树的最近公共祖先s
 * @Author : Richard.Wu
 * @Date: 2020-05-10 10:53
 * @Description :
 */

public class A236二叉树的最近公共祖先s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
        //在左子树中没有找到，那一定在右子树中
        if (leftCommonAncestor == null) {
            return rightCommonAncestor;
        }
        //在右子树中没有找到，那一定在左子树中
        if (rightCommonAncestor == null) {
            return leftCommonAncestor;
        }
        //不在左子树，也不在右子树，那说明是根节点
        return root;

    }
}
