package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A106从中序与后序遍历构造二叉树s;

/**
 * @ClassName : A106从中序与后序遍历构造二叉树p
 * @Author : Richard.Wu
 * @Date: 2020-03-25 16:36
 * @Description :
 *
 * 2020-03-27
 *
 *
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


        if (inorder == null ||
                postorder == null ||
                inorder.length == 0 ||
                postorder.length == 0)
        {
            return null;
        }

            return build(inorder,0,inorder.length-1,postorder, 0,postorder.length-1);

    }


    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {

        if (is > ie || ps > pe) {
            return null;
        }

        int idx = search(inorder, postorder[pe]);

        TreeNode root = new TreeNode(inorder[idx]);

        root.left = build(inorder, is, idx - 1, postorder, ps, ps + idx - is - 1);
        root.right = build(inorder, idx + 1, ie, postorder, ps + idx - is, pe - 1);

        return root;
    }


    private int search(int[] inorder, int data) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == data) {
                return i;
            }
        }
        return -1;

    }


}
