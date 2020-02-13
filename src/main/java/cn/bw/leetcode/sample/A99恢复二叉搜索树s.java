package cn.bw.leetcode.sample;

/**
 * @ClassName : A99恢复二叉搜索树s
 * @Author : Richard.Wu
 * @Date: 2020-02-12 17:17
 * @Description :
 */

public class A99恢复二叉搜索树s {
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

        if(root == null) {
            return;
        }

        pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
//        int temp = fst.val;
//        fst.val = snd.val;
//        snd.val = temp;
        swap(fst,snd);
    }

    private void inorder(TreeNode root){

        if(root == null){
            return;
        }

        inorder(root.left);
        if(fst == null && pre.val > root.val){
            fst = pre;
        }
        if(fst != null && pre.val > root.val){
            snd = root;
        }
        pre = root;
        inorder(root.right);


    }

    private void swap(TreeNode f1,TreeNode f2){
        int tmp = f1.val;
        f1.val = f2.val;
        f2.val = tmp;
    }

}
