package cn.bw.leetcode.sample;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : A117填充每个节点的下一个右侧节点指针II
 * @Author : Richard.Wu
 * @Date: 2020-04-09 10:41
 * @Description :
 */

public class A117填充每个节点的下一个右侧节点指针II {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    // BFS
    public Node connect(Node root) {
        if(root==null)return root;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

            Node pre = null;

            int size = queue.size();
            for(int i=0;i<size;i++){

                Node cur = queue.poll();
                if(i>0){
                    pre.next=cur;
                }
                pre = cur;

                if(cur.left!=null){
                    queue.offer(cur.left);
                }

                if(cur.right!=null){
                    queue.offer(cur.right);
                }

            }

        }

        return root;

    }



}
