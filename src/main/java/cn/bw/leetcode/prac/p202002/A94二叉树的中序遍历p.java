package cn.bw.leetcode.prac.p202002;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A94二叉树的中序遍历p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-05 13:40
 */

public class A94二叉树的中序遍历p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results= new LinkedList<>();

        if(root==null)
            return results;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur!=null||!stack.isEmpty()){

            while (cur!=null){

                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            results.add(cur.val);
            cur = cur.right;

        }

        return results;

    }

    //递归
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> results=new LinkedList<>();
        if(root==null)return results;

        inorder(root, results);
        return results;


    }

    private  void inorder(TreeNode root, List<Integer> results){
        if(root==null)return;

        inorder(root.left,results);
        results.add(root.val);
        inorder(root.right,results);

    }




}
