package cn.bw.leetcode.prac.p202002;

import java.rmi.activation.ActivationGroup_Stub;

/**
 * @ClassName : A98验证二叉搜索树p0
 * @Author : Richard.Wu
 * @Date: 2020-02-12 12:44
 * @Description :
 */

public class A98验证二叉搜索树p0 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right){

        if(root==null){
            return true;
        }else if(root.val<=left ||root.val>=right){
            return false;
        }else{
            return isValidBST(root.left, left, (long)root.val)&&
                    isValidBST(root.right,(long)root.val,right);
        }
    }
}
