package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A236二叉树的最近公共祖先s;

/**
 * @ClassName : A236二叉树的最近公共祖先p
 * @Author : Richard.Wu
 * @Date: 2020-05-10 11:07
 * @Description :
 */

public class A236二叉树的最近公共祖先p {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null||root==p||root==q)return root;

        TreeNode leftSubCo = lowestCommonAncestor(root.left,p, q);
        TreeNode rightSubCo = lowestCommonAncestor(root.right,p,q);

        if(leftSubCo==null){
            return rightSubCo;
        }
        if(rightSubCo==null){
            return leftSubCo;
        }

        return root;

    }


}
