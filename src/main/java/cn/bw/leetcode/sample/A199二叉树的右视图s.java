package cn.bw.leetcode.sample;

import java.util.*;

/**
 * @ClassName : A199二叉树的右视图s
 * @Author : Richard.Wu
 * @Date: 2020-04-22 21:22
 * @Description :
 */

public class A199二叉树的右视图s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // BFS   best

    public List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }


    ///dfs 解法

    List<Integer> res = new ArrayList<>();


    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }


    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


    //////////

    int level = -1;

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> results = new LinkedList<>();
        rightsize(root, 0, results);

        return results;
    }

    public void rightsize(TreeNode root, int n, List<Integer> result) {
        if (root == null) return;
        if (n > level) {
            level = n;
            result.add(root.val);
        }

        rightsize(root.right, n + 1, result);
        rightsize(root.left, n + 1, result);
    }


}
