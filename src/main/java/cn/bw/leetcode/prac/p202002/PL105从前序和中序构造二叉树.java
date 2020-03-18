package cn.bw.leetcode.prac.p202002;


/**
 * @ClassName : PL105从前序和中序构造二叉树
 * @Author : Richard.Wu
 * @Date: 2020-03-17 15:51
 * @Description :
 */

public class PL105从前序和中序构造二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return build(preorder,inorder,0,inorder.length-1);

    }

    int index=0;
    private TreeNode build(int[] preorder, int[] inorder, int left, int right){

        if(left>right)return null;

        int cur=searchInorder(inorder,preorder[index], left,right);

        TreeNode root=new TreeNode(inorder[cur]);
        index++;
        root.left=build(preorder, inorder, left, cur-1);
        root.right=build(preorder, inorder, cur+1, right);

        return root;

    }


    private int searchInorder(int[] inorder, int data, int s, int e){

        for(int i=e;i>=s;i--){
            if(inorder[i]==data){
                return i;
            }
        }
        //找不到
        return -1;
    }




}
