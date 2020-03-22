package cn.bw.leetcode.utils;

import cn.bw.leetcode.prac.p202002.PL173二叉搜索树迭代器;

/**
 * @ClassName : BSTBuilder
 * @Author : Richard.Wu
 * @Date: 2020-03-22 16:19
 * @Description :
 */

public class BSTBuilder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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


    public static void main(String[] args) {

        int[] nums = {7, 3, 15, 9, 20};

        TreeNode root= new TreeNode(7);

        for(int i=1;i<nums.length;i++){
            BSTBuilder.insert(nums[i],root);
        }





        System.out.println("end");
    }
}
