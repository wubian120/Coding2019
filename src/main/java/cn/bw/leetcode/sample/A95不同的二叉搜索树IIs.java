package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A95不同的二叉搜索树IIs
 * @Description : leetcode 95 不同的二叉搜索树II
 *
 *
 *
 * @Author : Richard.Wu
 * @Date: 2020-01-23 23:58
 */

public class A95不同的二叉搜索树IIs {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(0, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> trees = new LinkedList<>();
        if (start == end) {
            trees.add(null);
            return trees;
        }

        if (start + 1 == end) {
            TreeNode one = new TreeNode(start + 1);
            trees.add(one);
        } else if (start + 2 == end) {
            TreeNode fstOne = new TreeNode(start + 1);
            TreeNode fstOnePlus = new TreeNode(start + 2);
            fstOne.right = fstOnePlus;
            trees.add(fstOne);

            TreeNode sndOne = new TreeNode(start + 1);
            TreeNode sndOnePlus = new TreeNode(start + 2);
            sndOnePlus.left = sndOne;
            trees.add(sndOnePlus);

        } else {

            for (int i = start; i < end; i++) {
                List<TreeNode> leftSubTree = generateTrees(start, i);
                List<TreeNode> rightSubTree = generateTrees(i + 1, end);

                int leftSize = leftSubTree.size();
                int rightSize = rightSubTree.size();

                for (int l = 0; l < leftSize; l++) {
                    for (int r = 0; r < rightSize; r++) {
                        TreeNode root = new TreeNode(i + 1);
                        root.left = leftSubTree.get(l);
                        root.right = rightSubTree.get(r);
                        trees.add(root);
                    }
                }

            }


        }
        return trees;

    }
}
