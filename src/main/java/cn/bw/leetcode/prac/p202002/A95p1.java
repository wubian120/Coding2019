package cn.bw.leetcode.prac.p202002;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A95p1
 * @Author : Richard.Wu
 * @Date: 2020-02-13 12:30
 * @Description :
 */

public class A95p1 {


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
            return Collections.emptyList();
        }
        return generate(1,n);
    }

    private List<TreeNode> generate(int start, int end){

        List<TreeNode> tree = new LinkedList<>();
        if(start>end){
            tree.add(null);
            return tree;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> left = generate(start,i-1);
            List<TreeNode> right = generate(i+1,end);

            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    tree.add(root);
                }
            }
        }
        return tree;
    }




}
