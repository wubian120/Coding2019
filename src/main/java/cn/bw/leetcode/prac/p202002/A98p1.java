package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A98p1
 * @Author : Richard.Wu
 * @Date: 2020-02-14 22:53
 * @Description :
 */

public class A98p1 {

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
        if(root==null)return true;

        if(root.val<=left||root.val>=right){
            return false;
        }

        return isValidBST(root.left,left,root.val)&&
                isValidBST(root.right,root.val,right);
    }
}
