package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A105从前序与中序遍历序列构造二叉树s;

/**
 * @ClassName : A105从前序与中序遍历序列构造二叉树p
 * @Author : Richard.Wu
 * @Date: 2020-03-20 13:13
 * @Description :
 */

public class A105从前序与中序遍历序列构造二叉树p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder == null || preorder == null) {
            return null;
        }
        return build(inorder, preorder, 0, inorder.length - 1);

    }

    int index = 0;

    private TreeNode build(int[] inorder, int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int curIdx = search(inorder, preorder[index]);
        index++;
        TreeNode root = new TreeNode(inorder[curIdx]);

        root.left = build(inorder, preorder, left, curIdx - 1);
        root.right = build(inorder, preorder, curIdx + 1, right);

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
