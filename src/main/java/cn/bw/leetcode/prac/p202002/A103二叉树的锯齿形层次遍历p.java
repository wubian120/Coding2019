package cn.bw.leetcode.prac.p202002;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A103二叉树的锯齿形层次遍历r0
 * @Author : Richard.Wu
 * @Date: 2020-02-21 08:00
 * @Description :
 * <p>
 * prac :
 * <p>
 * 1.2020-02-21    read
 * 2.2020-02-23
 */

public class A103二叉树的锯齿形层次遍历p {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //题目方法：

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root==null)return Collections.emptyList();
        List<List<Integer>> results=new LinkedList<>();
        handleZLevel(root,0,results);

        return results;
    }

    private void handleZLevel(TreeNode root, int level, List<List<Integer>> results){

        if(root==null)return;

        if(results.size()==level){
            results.add(new LinkedList<>());
        }

        if((level&1)!=0){
            results.get(level).add(0,root.val);
        }else if((level&1)==0){
            results.get(level).add(root.val);
        }

        handleZLevel(root.left,level+1,results);
        handleZLevel(root.right,level+1,results);

    }




}
