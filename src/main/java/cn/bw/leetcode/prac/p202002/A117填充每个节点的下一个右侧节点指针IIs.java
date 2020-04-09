package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A117填充每个节点的下一个右侧节点指针II;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : A117填充每个节点的下一个右侧节点指针IIs
 * @Author : Richard.Wu
 * @Date: 2020-04-09 11:07
 * @Description :
 */

public class A117填充每个节点的下一个右侧节点指针IIs {

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

        public Node(int _val,
                    Node _left,
                    Node _right,
                    Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    //层次遍历 ，  queue 保存下一层 node
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i > 0) {
                    pre.next = cur;
                }

                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

        }


        return root;
    }

}
