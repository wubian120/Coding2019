package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A102p1
 * @Author : Richard.Wu
 * @Date: 2020-02-17 14:49
 * @Description :
 */

public class A102p1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new LinkedList<>();
        if (root == null) return results;
        List<TreeNode> tree = new LinkedList<>();

        tree.add(root);
        while (!tree.isEmpty()) {
            List<Integer> levelVals = new LinkedList<>();
            List<TreeNode> levelNodes = new LinkedList<>();

            for (TreeNode cur : tree) {
                levelVals.add(cur.val);
                if (cur.left != null) {
                    levelNodes.add(cur.left);
                }
                if (cur.right != null) {
                    levelNodes.add(cur.right);
                }
            }

            results.add(levelVals);
            tree = levelNodes;
        }

        return results;


    }


}
