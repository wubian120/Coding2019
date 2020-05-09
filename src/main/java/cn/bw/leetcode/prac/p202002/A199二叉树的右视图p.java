package cn.bw.leetcode.prac.p202002;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : A199
 * @Author : Richard.Wu
 * @Date: 2020-04-24 21:17
 * @Description :
 *
 * 2020-04-24
 * 2020-05-01
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


    public List<Integer> rightSideView(TreeNode root) {

      List<Integer> results=new LinkedList<>();
      if(root==null)return results;

      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()){
          int size= queue.size();
          for(int i=0;i<size;i++){

              TreeNode node = queue.poll();
              if(node.left!=null){
                  queue.offer(node.left);
              }

              if(node.right!=null){
                  queue.offer(node.right);
              }

              if(i==size-1){
                  results.add(node.val);
              }

          }
      }

      return results;



    }



}
