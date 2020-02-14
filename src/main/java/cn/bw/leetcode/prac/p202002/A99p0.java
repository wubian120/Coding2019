package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A99p0
 * @Author : Richard.Wu
 * @Date: 2020-02-14 23:10
 * @Description :
 */

public class A99p0 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode pre, fst, snd;
    public void recoverTree(TreeNode root) {

        pre=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        swap(fst,snd);

    }

    private void inorder(TreeNode root){

        if(root==null)return;

        inorder(root.left);

        if(fst==null && pre.val>root.val){
            fst=pre;
        }
        if(fst!=null && pre.val>root.val){
            snd=root;
        }
        pre=root;
        inorder(root.right);
    }

    private void swap(TreeNode t1, TreeNode t2){
        int t=t1.val;
        t1.val=t2.val;
        t2.val=t;
    }


}
