package cn.bw.leetcode.prac.p202002;


import cn.bw.leetcode.utils.BSTBuilder;

import java.util.Stack;

/**
 * @ClassName : PL173二叉搜索树迭代器
 * @Author : Richard.Wu
 * @Date: 2020-03-22 15:23
 * @Description :
 */

public class PL173二叉搜索树迭代器 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur;

    public PL173二叉搜索树迭代器(TreeNode root) {
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {

        int result=-1;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur = stack.pop();
            result=cur.val;
            cur = cur.right;
            break;
        }

        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return cur!=null||!stack.isEmpty();

    }


    public static void insert(int val, TreeNode root) {

        TreeNode cur = root;
        TreeNode parent = root;
        boolean isLeft = false;


        while (cur != null) {
            parent = cur;
            if (val <= cur.val) {
                cur = cur.left;
                isLeft = true;
            } else {
                cur = cur.right;
                isLeft = false;
            }
        }

        TreeNode node = new TreeNode(val);
        if (isLeft) {
            parent.left = node;
        } else {
            parent.right = node;
        }

    }


}
