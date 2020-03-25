package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A102二叉树的层次遍历s;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : PL107二叉树的层次II
 * @Author : Richard.Wu
 * @Date: 2020-03-22 21:50
 * @Description :
 */

public class PL107二叉树的层次遍历II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null)return Collections.emptyList();

        List<List<Integer>> results=new LinkedList<>();
        List<TreeNode> tree=new LinkedList<>();
        tree.add(root);
        while (!tree.isEmpty()){

            List<Integer> vals=new LinkedList<>();
            List<TreeNode> level=new LinkedList<>();

            for(TreeNode node:tree){

                if(node.left!=null){
                    level.add(node.left);
                }

                if(node.right!=null){
                    level.add(node.right);
                }
                vals.add(node.val);
            }
            results.add(0,vals);
            tree=level;

        }


        return results;



    }
}
