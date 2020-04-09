package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A116填充每个节点的右侧节点
 * @Author : Richard.Wu
 * @Date: 2020-04-07 10:17
 * @Description :
 */

public class A116填充每个节点的右侧节点p {


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public Node connect(Node root) {

        Node pre = root;

        while (pre !=null){

            Node cur = pre;

            while (cur !=null){
                if(cur.left!=null){
                    cur.left.next = cur.right;
                }

                if(cur.right!=null &&cur.next!=null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }

        return root;

    }


}
