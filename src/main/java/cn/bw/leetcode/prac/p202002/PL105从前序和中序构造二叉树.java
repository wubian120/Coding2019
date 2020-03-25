package cn.bw.leetcode.prac.p202002;


/**
 * @ClassName : PL105从前序和中序构造二叉树
 * @Author : Richard.Wu
 * @Date: 2020-03-17 15:51
 * @Description :
 */

public class PL105从前序和中序构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null ||
                inorder == null || preorder.length == 0 ||
                inorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    int idx = 0;

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || idx >= inorder.length) return null;


        int inInde=search(inorder,left,right,preorder[idx]);

        idx++;
        TreeNode root=new TreeNode(inorder[inInde]);

        root.left=build(preorder, inorder, left, inInde-1);
        root.right=build(preorder, inorder, inInde+1, right);

        return root;

    }

    private int search(int[] inorder, int left, int right, int data) {

        for(int i=right;i>=left;i--){
            if(inorder[i]==data){
                return i;
            }
        }
        return -1;


    }


}
