package cn.bw.leetcode.sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A145er
 * @Author : Richard.Wu
 * @Date: 2020-03-26 10:19
 * @Description :
 */

public class A145二叉树的后序遍历s {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //栈解法
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        if(root==null)return results;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){

            TreeNode cur=stack.pop();
            results.add(0,cur.val);

            if(cur.left!=null){
                stack.push(cur.left);
            }

            if(cur.right!=null){
                stack.push(cur.right);
            }

        }

        return results;


    }


    //递归解法
    public List<Integer> postorderTraversal1(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        post(root, results);

        return results;

    }

    private void post(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }

        post(root.left, results);
        post(root.right, results);
        results.add(root.val);

    }

}
