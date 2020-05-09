package cn.bw.leetcode.prac.p202002;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : A102二叉树的层次遍历p0
 * @Author : Richard.Wu
 * @Date: 2020-02-16 23:58
 * @Description :
 *
 * 2020-05-03
 *
 *
 */

public class A102二叉树的层次遍历p0 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

      List<List<Integer>> levels=new LinkedList<>();

      if(root==null)return levels;

      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);

      int level=0;

      while (!queue.isEmpty()){

          levels.add(new LinkedList<>());

          int levelLen=queue.size();

          for(int i=0;i<levelLen;i++){
              TreeNode node =queue.poll();

              levels.get(level).add(node.val);

              if(node.left!=null){
                  queue.add(node.left);
              }
              if(node.right!=null){
                  queue.add(node.right);
              }
          }
          level++;

      }

      return levels;



    }
}
