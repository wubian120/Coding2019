package cn.bw.leetcode.sample;

/**
 * @ClassName : A116填充每个节点的下一个右侧节点
 * @Author : Richard.Wu
 * @Date: 2020-04-07 09:45
 * @Description :
 *
 *  层次遍历
 *
 */

public class A116填充每个节点的下一个右侧节点s {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node pre = root;
        while (pre != null){

            Node cur = pre;
            while (cur != null){
                if (cur.left != null){
                    cur.left.next = cur.right;
                }
                if(cur.right != null && cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;





    }
}
