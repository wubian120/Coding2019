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

        double pre = -Double.MAX_VALUE;

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur !=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val<=pre){
                return false;
            }
            pre = cur.val;
            cur = cur.right;
        }

        return true;

    }

}
