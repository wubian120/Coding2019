package cn.bw.leetcode.sample;

/**
 * @ClassName : A108
 * @Author : Richard.Wu
 * @Date: 2020-03-26 10:41
 * @Description :
 */

public class A108将有序数组转换为二叉搜索树s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums==null||nums.length==0){
            return null;
        }

        return build(nums,0,nums.length-1);
    }


    private TreeNode build(int[] data, int left, int right){

        if(left==right){
            return new TreeNode(data[left]);
        }

        if(left>right){
            return null;
        }

        int mid = left+ (right-left)/2;

        TreeNode root = new TreeNode(data[mid]);
        root.left=build(data,left, mid-1);
        root.right = build(data,mid+1,right);

        return root;

    }


}
