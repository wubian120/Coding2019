package cn.bw.leetcode.prac.p202002;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A102p2
 * @Author : Richard.Wu
 * @Date: 2020-02-19 07:56
 * @Description :
 */

public class A102p2 {

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

        List<List<Integer>> results = new LinkedList<>();

        List<TreeNode> treeNodes=new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            List<Integer> levelVals=new LinkedList<>();
            List<TreeNode> levelNodes=new LinkedList<>();

            for(TreeNode cur:treeNodes){
                levelVals.add(cur.val);

                if(cur.left!=null){
                    levelNodes.add(cur.left);
                }
                if(cur.right!=null){
                    levelNodes.add(cur.right);
                }

            }
            results.add(levelVals);
            treeNodes=levelNodes;
        }
        return results;
    }
}
