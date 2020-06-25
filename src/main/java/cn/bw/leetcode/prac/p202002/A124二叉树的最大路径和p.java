package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A124二叉树的最大路径和p
 * @Author : Richard.Wu
 * @Date: 2020-06-21 09:38
 * @Description :
 */

public class A124二叉树的最大路径和p {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {

          if(root==null)return 0;

          getMaxPth(root);
          return maxValue;

    }

    int maxValue = Integer.MIN_VALUE;

    private int getMaxPth(TreeNode cur){
        int left = 0, right =0;
        int val = cur.val;

        if(cur.left!=null){
            left = getMaxPth(cur.left);
        }
        if(cur.right!=null){
            right = getMaxPth(cur.right);
        }

        val += (left>0?left:0) + (right>0?right:0);

        maxValue = Math.max(maxValue,val);

        return cur.val+Math.max((left>0?left:0),(right>0?right:0));
    }
}
