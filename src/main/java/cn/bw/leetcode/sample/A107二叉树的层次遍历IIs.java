package cn.bw.leetcode.sample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A107二叉树的层次遍历IIs
 * @Author : Richard.Wu
 * @Date: 2020-03-20 11:02
 * @Description :
 * <p>
 * 从上往下走，  从前往后插
 */

public class A107二叉树的层次遍历IIs {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) return Collections.emptyList();

        List<List<Integer>> results = new LinkedList<>();

        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> values = new LinkedList<>();
            List<TreeNode> levelNodes = new LinkedList<>();

            for (TreeNode cur : nodes) {

                if(cur.left!=null){
                    levelNodes.add(cur.left);
                }
                if(cur.right!=null){
                    levelNodes.add(cur.right);
                }

                values.add(cur.val);


            }

            nodes = levelNodes;
            results.add(0,values);

        }

        return results;
    }

}
