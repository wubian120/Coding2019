package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : AReading
 * @Author : Richard.Wu
 * @Date: 2020-02-25 11:28
 * @Description :
 */

public class A0Reading {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 105.从前序和中序遍历序列构造二叉树
     */

    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, inorder.length - 1);

    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {

        if (left > right || index >= inorder.length) {
            return null;
        }

        int i = search(inorder, left, right, preorder[index]);

        TreeNode root = new TreeNode(preorder[index]);
        i++;
        root.left = build(preorder, inorder, left, i - 1);
        root.right = build(preorder, inorder, i + 1, right);
        return root;

    }

    private int search(int[] inorder, int start, int end, int data) {

        for (int i = end; i >= start; i--) {
            if (inorder[i] == data) {
                return i;
            }
        }

        return -1;
    }

}
