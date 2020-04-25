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


    public List<Integer> rightSideView1(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }


}
