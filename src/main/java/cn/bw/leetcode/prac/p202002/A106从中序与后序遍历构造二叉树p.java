package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A106从中序与后序遍历构造二叉树s;

/**
 * @ClassName : A106从中序与后序遍历构造二叉树p
 * @Author : Richard.Wu
 * @Date: 2020-03-25 16:36
 * @Description :
 * <p>
 * 2020-03-27
 */

public class A106从中序与后序遍历构造二叉树p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder==null||postorder==null){
            return null;
        }
        return build(inorder,postorder,0,inorder.length-1, 0,postorder.length-1);


    }

    private TreeNode build(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {

        if (is > ie || ps > pe) {
            return null;
        }

        int curIdx = search(inorder, postorder[pe]);

        TreeNode root = new TreeNode(inorder[curIdx]);
        root.left = build(inorder, postorder, is, curIdx - 1, ps, ps + curIdx - is - 1);
        root.right = build(inorder, postorder, curIdx + 1, ie, ps + curIdx - is, pe - 1);
        return root;

    }

    private int search(int[] inorder, int data) {
        int i = 0;
        while (inorder[i] != data) {
            i++;
        }
        return i;
    }


}
