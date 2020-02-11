package cn.bw.leetcode.prac.p202002;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A不同的二叉搜索树IIp0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 11:55
 */

public class A95不同的二叉搜索树IIp0 {

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

        List<TreeNode> tree=new LinkedList<>();
        if(start>end){
            tree.add(null);
            return tree;
        }

        for(int i=start;i<=end;i++){

            List<TreeNode> leftSub=generate(start,i-1);
            List<TreeNode> rightSub = generate(i+1,end);

            for(TreeNode left:leftSub){
                for(TreeNode right:rightSub){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    tree.add(root);
                }
            }
        }
        return tree;

    }

    public static void main(String[] args){
        int n= 10;

        A95不同的二叉搜索树IIp0 a = new A95不同的二叉搜索树IIp0();
        List<TreeNode> tree= a.generateTrees(n);

    }


}
