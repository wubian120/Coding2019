package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A94p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-08 13:51
 */

public class A94p1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> tree = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            tree.add(cur.val);
            cur = cur.right;
        }

        return tree;

    }

    public List<Integer> inorderTraversal1(TreeNode root) {

      List<Integer> result = new LinkedList<>();
      inorder(root,result);

      return result;
    }

    public void inorder(TreeNode root, List<Integer> treeVals){
        if(root==null)return;

        inorder(root.left,treeVals);
        treeVals.add(root.val);
        inorder(root.right,treeVals);
    }

}
