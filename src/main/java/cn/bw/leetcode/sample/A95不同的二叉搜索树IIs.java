package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A95不同的二叉搜索树IIs
 * @Description : leetcode 95 不同的二叉搜索树II
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

        if(n==0){
            return Collections.EMPTY_LIST;
        }
        return generate(1,n);

    }

    private List<TreeNode> generate(int start, int end){

        List<TreeNode> tree = new LinkedList<>();
        if(start>end){
            tree.add(null);
            return tree;
        }

        // 注意： 边界， i<=end
        for(int i=start;i<=end;i++){
            List<TreeNode> leftSub=generate(start,i-1);
            List<TreeNode> rightSub=generate(i+1,end);

            for(TreeNode left:leftSub){
                for(TreeNode right:rightSub){

                    TreeNode cur=new TreeNode(i);
                    cur.left=left;
                    cur.right=right;

                    tree.add(cur);
                }
            }
        }


        return tree;
    }
}
