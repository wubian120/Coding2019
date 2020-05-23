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
        List<List<Integer>> results=new LinkedList<>();
        if(root==null)return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=0;
        while (!queue.isEmpty()){
            results.add(new LinkedList<>());
            int size=queue.size();

            for(int i=0;i<size;i++){
                TreeNode curNode=queue.remove();
                results.get(level).add(curNode.val);
                if(curNode.left!=null){
                    queue.add(curNode.left);
                }
                if(curNode.right!=null){
                    queue.add(curNode.right);
                }

            }
            level++;
        }
        return results;
    }
}
