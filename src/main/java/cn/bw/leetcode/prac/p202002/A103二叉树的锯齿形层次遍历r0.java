package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A103二叉树的锯齿形层次遍历r0
 * @Author : Richard.Wu
 * @Date: 2020-02-21 08:00
 * @Description :
 */

public class A103二叉树的锯齿形层次遍历r0 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> results=new LinkedList<>();
        handleZigzag(root,0,results);
        return results;
    }


    private void handleZigzag(TreeNode root, int level,List<List<Integer>> results){

        if(root !=null){
            if(level==results.size()){
                results.add(new LinkedList<>());
            }

//            if((level&1)==1){
            if((level&1)==1){
                results.get(level).add(0,root.val);
            }
            if((level&1)==0){
                results.get(level).add(root.val);
            }

            handleZigzag(root.left,level+1,results);
            handleZigzag(root.right,level+1,results);
        }

    }

}
