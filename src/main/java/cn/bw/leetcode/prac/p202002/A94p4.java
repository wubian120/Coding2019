package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A94p4
 * @Author : Richard.Wu
 * @Date: 2020-02-18 19:00
 * @Description :
 */

public class A94p4 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // 栈
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results=new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){

            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            results.add(cur.val);
            cur=cur.right;
        }

        return results;

    }



    //递归
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> results=new LinkedList<>();
        inorder(root,results);
        return results;
    }

    public void inorder(TreeNode cur, List<Integer> results){
        if(cur==null)return;

        inorder(cur.left,results);
        results.add(cur.val);
        inorder(cur.right,results);
    }

}
