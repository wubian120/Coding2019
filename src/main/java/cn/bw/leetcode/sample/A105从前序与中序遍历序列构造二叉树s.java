package cn.bw.leetcode.sample;

/**
 * @ClassName : A105从前序与中序遍历序列构造二叉树s
 * @Author : Richard.Wu
 * @Date: 2020-02-25 11:03
 * @Description :
 *
 * 思路：
 *  1.前序 第一个是 root，  中序 root 把 数组分为 左右 两个子序列
 *  2.去 中序 中找 root 索引号， 中序 root
 *
 */

public class A105从前序与中序遍历序列构造二叉树s {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,inorder.length-1);
    }

    int index = 0;


    private int search(int[] inorder, int start, int end, int data) {

        //从后往前 找
        for (int i = end; i >= start; i--) {
            if (inorder[i] == data) {
                return i;
            }
        }
        //没找到
        return -1;
    }

    /***
     *
     * @param preorder 前序 序列
     * @param inorder  中序 序列
     * @param left     中序左子序列 索引
     * @param right    中序右子序列 索引
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index >= inorder.length) {
            return null;
        }

        int j = search(inorder, left, right, preorder[index]);

        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, inorder, left, j - 1);
        root.right = build(preorder, inorder, j + 1, right);
        return root;
    }


}
