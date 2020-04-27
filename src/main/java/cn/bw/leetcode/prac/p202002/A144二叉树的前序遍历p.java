package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A144二叉树的前序遍历s;

import java.util.Collections;
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

        List<Integer> results=new LinkedList<>();
        preorder(root,results);

        return results;

    }

    private void preorder(TreeNode root, List<Integer> results){

        if(root==null)return;

        results.add(root.val);
        preorder(root.left,results);
        preorder(root.right,results);

    }

    public List<Integer> preorderTraversalStack(TreeNode root) {

        if(root==null)return Collections.emptyList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode=root;
        List<Integer> results=new LinkedList<>();
        while (curNode!=null||!stack.isEmpty()){

            while (curNode!=null){
                results.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }

            if(!stack.isEmpty()){
                curNode = stack.pop();
                curNode = curNode.right;

            }

        }

        return results;



    }

}
