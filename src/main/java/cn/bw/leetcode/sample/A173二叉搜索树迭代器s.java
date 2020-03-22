package cn.bw.leetcode.sample;

import cn.bw.leetcode.prac.p202002.PL173二叉搜索树迭代器;
import cn.bw.leetcode.utils.BSTBuilder;

import java.util.Stack;

/**
 * @ClassName : A173二叉搜索树迭代器s
 * @Author : Richard.Wu
 * @Date: 2020-03-22 11:41
 * @Description :
 */

public class A173二叉搜索树迭代器s {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = null;

    public A173二叉搜索树迭代器s(TreeNode root) {
        cur = root;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int res = -1;
        while (cur != null || !stack.isEmpty()) {
            // 节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; // 考虑左子树
            }
            // 节点为空，就出栈
            cur = stack.pop();
            res = cur.val;
            // 考虑右子树
            cur = cur.right;
            break;
        }

        return res;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }


    public void insert(int val, TreeNode root) {

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

    public static void main(String... args) {

        int[] nums = {7, 3, 15, 9, 20};

        TreeNode root = new A173二叉搜索树迭代器s.TreeNode(7);

        A173二叉搜索树迭代器s a = new A173二叉搜索树迭代器s(root);

        for (int i = 1; i < nums.length; i++) {
            a.insert(nums[i], root);
        }

        for(int i=0;i<nums.length;i++){
            System.out.println(a.next());
        }



//        System.out.println("result:" + result);

    }


}
