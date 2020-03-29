package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A144二叉树的前序遍历s;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A144二叉树的前序遍历p
 * @Author : Richard.Wu
 * @Date: 2020-03-29 23:11
 * @Description :
 */

public class A144二叉树的前序遍历p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> results = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {

            while (cur !=null){
                results.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;

        }

        return results;
    }

}
