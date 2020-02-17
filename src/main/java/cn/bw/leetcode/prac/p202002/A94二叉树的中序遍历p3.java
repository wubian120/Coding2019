package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A94二叉树的中序遍历p3
 * @Author : Richard.Wu
 * @Date: 2020-02-17 15:52
 * @Description :
 */

public class A94二叉树的中序遍历p3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;

            }
            cur = stack.pop();
            results.add(cur.val);
            cur = cur.right;

        }
        return results;

    }


}
