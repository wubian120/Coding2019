package cn.bw.leetcode.prac.p202002;


import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A199
 * @Author : Richard.Wu
 * @Date: 2020-04-24 21:17
 * @Description :
 *
 * 2020-04-24
 *
 *
 */

public class A199二叉树的右视图p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int level=-1;
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> results= new LinkedList<>();
        rightView(root,0,results);
        return results;
    }

    private void rightView(TreeNode root, int n, List<Integer> results){
        if(root==null)
            return;

        if(n>level){
            level=n;
            results.add(root.val);
        }

        rightView(root.right, n+1, results);
        rightView(root.left, n+1, results);
    }


}
