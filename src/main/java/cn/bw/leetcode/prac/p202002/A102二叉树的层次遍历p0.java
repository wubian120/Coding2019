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

        if (root == null) return Collections.emptyList();

        List<List<Integer>> results=new LinkedList<>();
        List<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while (!tree.isEmpty()) {

            List<Integer> vals = new LinkedList<>();
            List<TreeNode> level = new LinkedList<>();

            for(TreeNode node:tree){

                if(node.left!=null){
                    level.add(node.left);
                }
                if(node.right!=null){
                    level.add(node.right);
                }

                vals.add(node.val);

            }

            tree=level;
            results.add(vals);

        }

        return results;


    }
}
