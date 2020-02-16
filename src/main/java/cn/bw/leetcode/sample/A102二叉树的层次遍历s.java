package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : A102二叉树的层次遍历s
 * @Author : Richard.Wu
 * @Date: 2020-02-16 23:46
 * @Description :
 */

public class A102二叉树的层次遍历s {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();

        List<TreeNode> treeList = new ArrayList<>();

        if (root == null) return results;

        treeList.add(root);

        while (!treeList.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            List<TreeNode> nodeList = new LinkedList<>();

            for (TreeNode currentNode : treeList) {
                values.add(currentNode.val);
                if (currentNode.left != null)
                    nodeList.add(currentNode.left);
                if (currentNode.right != null)
                    nodeList.add(currentNode.right);

            }
            treeList = nodeList;
            results.add(values);
        }
        return results;

    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        handleLevelOrder(root,results,0);
        return results;
    }

    private void handleLevelOrder(TreeNode root, List<List<Integer>> results, int dept) {
        if (root == null) { return; }

        if (dept >= results.size()) {
            results.add(new ArrayList<>());
        }
        results.get(dept).add(root.val);

        if (root.left != null) {
            handleLevelOrder(root.left, results, dept + 1);
        }
        if (root.right != null) {
            handleLevelOrder(root.right, results, dept + 1);
        }
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }

}
