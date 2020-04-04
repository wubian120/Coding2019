package cn.bw.leetcode.prac.p202002;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A145二叉树的后序遍历p
 * @Author : Richard.Wu
 * @Date: 2020-03-29 23:23
 * @Description :
 */

public class A145二叉树的后序遍历p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            results.add(0,cur.val);

            if(cur.left!=null){
                stack.push(cur.left);
            }

            if(cur.right !=null){
                stack.push(cur.right);
            }
        }

        return results;

    }
}
