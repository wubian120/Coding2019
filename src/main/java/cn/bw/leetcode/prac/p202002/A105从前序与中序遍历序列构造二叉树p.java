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

        if(preorder==null||inorder==null){
            return null;
        }


        return build(preorder,inorder,0,inorder.length-1);

    }

    int index = 0;

    private TreeNode build(int[] preorder, int[] inorder, int left, int right){

        if(left>right||index>=preorder.length){
            return null;
        }

        int curIdx=search(inorder,preorder[index]);

        TreeNode root = new TreeNode(inorder[curIdx]);
        index++;
        root.left = build(preorder,inorder,left, curIdx-1);
        root.right = build(preorder,inorder, curIdx+1, right);

        return root;
    }


    private int search(int[] inorder, int data){

        int i=0;

        while (inorder[i]!=data){
            i++;
        }
        return i;

    }


}
