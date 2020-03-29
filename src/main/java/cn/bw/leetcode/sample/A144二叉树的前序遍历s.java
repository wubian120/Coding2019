package cn.bw.leetcode.sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A144er
 * @Author : Richard.Wu
 * @Date: 2020-03-26 10:00
 * @Description :
 */

public class A144二叉树的前序遍历s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /***
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {


        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                results.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }


            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }


        return results;
    }


    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        if(root==null){
            return results;
        }
        preorder(root,results);

        return results;
    }

    public void preorder(TreeNode root, List<Integer> results){

        if(root ==null){
            return;
        }

        results.add(root.val);
        preorder(root.left,results);
        preorder(root.right,results);


    }



}
