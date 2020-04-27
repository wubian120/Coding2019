package cn.bw.leetcode.prac.p202002;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A102二叉树的层次遍历p0
 * @Author : Richard.Wu
 * @Date: 2020-02-16 23:58
 * @Description :
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

        List<List<Integer>> results= new LinkedList<>();
        if(root==null)return results;

        List<TreeNode> treeLevel=new LinkedList<>();

        treeLevel.add(root);
        while (!treeLevel.isEmpty()){

            List<TreeNode> level = new LinkedList<>();
            List<Integer> levelVals= new LinkedList<>();

            for(TreeNode node:treeLevel){

                levelVals.add(node.val);

                if(node.left!=null){
                    level.add(node.left);
                }
                if(node.right!=null){
                    level.add(node.right);
                }

            }

            results.add(levelVals);
            treeLevel = level;
        }

        return results;




    }
}
