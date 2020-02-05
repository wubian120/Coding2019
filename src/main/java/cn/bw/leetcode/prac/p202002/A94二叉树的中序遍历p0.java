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

public class A94二叉树的中序遍历p0 {

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

        List<Integer> results=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (curr!=null|| !stack.isEmpty()){

            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }

            curr=stack.pop();
            results.add(curr.val);
            curr=curr.right;

        }
        return results;

    }

    //递归
    public List<Integer> inorderTraversal1(TreeNode root) {

      List<Integer> res=new LinkedList<>();
      inorder(root,res);
      return res;

    }

    private void inorder(TreeNode root,List<Integer> res){
        if(root==null) return;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }


}
