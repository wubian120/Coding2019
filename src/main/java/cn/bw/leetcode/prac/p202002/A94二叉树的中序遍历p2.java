package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A94二叉树的中序遍历p2
 * @Author : Richard.Wu
 * @Date: 2020-02-13 11:49
 * @Description :
 */

public class A94二叉树的中序遍历p2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        // 注意条件 ｜｜
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

    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> results=new LinkedList<>();
        inorder(root,results);
        return results;

    }

    private void inorder(TreeNode root, List<Integer> result){
        if(root==null)return;

        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);

    }

}
