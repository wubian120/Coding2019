package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A102p3
 * @Author : Richard.Wu
 * @Date: 2020-02-21 09:56
 * @Description :
 */

public class A102p3 {

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
        if(root==null) return results;
        List<TreeNode> tree=new LinkedList<>();

        tree.add(root);
        while (!tree.isEmpty()){

            List<Integer> levelVals=new LinkedList<>();
            List<TreeNode> leveleNodes=new LinkedList<>();

            for(TreeNode node:tree){

                levelVals.add(node.val);
                if(node.left!=null){
                    leveleNodes.add(node.left);
                }
                if(node.right!=null){
                    leveleNodes.add(node.right);
                }

            }
            tree=leveleNodes;
            results.add(levelVals);
        }

        return results;

    }


}
