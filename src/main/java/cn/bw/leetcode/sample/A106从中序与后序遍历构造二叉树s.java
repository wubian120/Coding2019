package cn.bw.leetcode.sample;

/**
 * @ClassName : A106从中序与后序遍历构造二叉树s
 * @Author : Richard.Wu
 * @Date: 2020-03-18 09:48
 * @Description :
 *
 * 思路 ： 和 105前序中序序列构造二叉树是一样的
 */

public class A106从中序与后序遍历构造二叉树s {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null
                || postorder == null
                || inorder.length == 0
                || postorder.length == 0
                || inorder.length != postorder.length
        ) return null;

        return build(inorder,0, inorder.length-1, postorder,0, postorder.length-1);

    }

    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {

        if(is>ie|| ps>pe)return null;

        int cur = searchPos(inorder,postorder[pe]);

        TreeNode root = new TreeNode(inorder[cur]);

        //
        root.left= build(inorder, is, cur-1, postorder, ps, ps+cur-is-1);

        root.right = build(inorder, cur+1, ie, postorder, ps+cur-is, pe-1);

        return root;

    }

    private int searchPos(int[] inorder, int data) {
        int i = 0;
        while (inorder[i] != data) {
            i++;
        }
        return i;
    }


}
