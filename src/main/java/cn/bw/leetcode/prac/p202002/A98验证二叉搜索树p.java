package cn.bw.leetcode.prac.p202002;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.Stack;

/**
 * @ClassName : A98验证二叉搜索树p0
 * @Author : Richard.Wu
 * @Date: 2020-02-12 12:44
 * @Description :
 */

public class A98验证二叉搜索树p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

      Stack<TreeNode> stack = new Stack<>();

      double inorder=-Double.MAX_VALUE;

      while (!stack.isEmpty()||root!=null){

          while (root!=null){
              stack.push(root);
              root=root.left;
          }

          root=stack.pop();

          if(root.val<=inorder){
              return false;
          }
          inorder = root.val;
          root = root.right;
      }

      return true;

    }

}
