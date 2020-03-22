package cn.bw.leetcode.sample;

import java.util.Stack;

/**
 * @ClassName : A98验证二叉搜索树s
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 15:54
 */

public class A98验证二叉搜索树s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, Long left, Long right){
        if(root == null){
            return true;
        }
        if((long)root.val<=left || (long)root.val >= right){
            return false;
        }

        return isValidBST(root.left, left, (long)root.val) &&
                isValidBST(root.right, (long) root.val, right);

    }


    /** 中序遍历 版本  */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        //
        //因为一些 极端 测试case 导致 用这个
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
