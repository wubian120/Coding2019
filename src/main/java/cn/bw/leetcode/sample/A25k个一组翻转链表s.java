package cn.bw.leetcode.sample;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : A25k个一组翻转链表s
 * @Author : Richard.Wu
 * @Date: 2020-05-16 14:02
 * @Description :
 *
 * 栈解法；
 *
 * 用栈，我们把 k 个数压入栈中，然后弹出来的顺序就是翻转的！
 *
 * 这里要注意几个问题：
 *
 * 第一，剩下的链表个数够不够 k 个（因为不够 k 个不用翻转）；
 *
 * 第二，已经翻转的部分要与剩下链表连接起来。
 *
 * 尾插法：
 *
 *
 */

public class A25k个一组翻转链表s {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /***
     * 栈解法 ：
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupStack(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }


    /***
     * 尾插法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;

        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        len /= k;
        if (len == 0) {
            return head;
        }
        ListNode current = head;
        ListNode tail = current;

        for (int i = 0; i < len; i++) {

            ListNode newList = null;
            ListNode newHead = current;

            int count = k;
            //反转
            while (count > 0) {
                //             tmp
                //              |
                //current -> current.next
                // |
                //newList <-  tmp.next
                tmp = current;
                current = current.next;
                tmp.next = newList;
                newList = tmp;
                count--;
            }

            if (i == 0) {
                head = newList;
            } else {
                tail.next = newList;
                tail = newHead;
            }
        }

        while (current != null) {
            //尾.next -> current;
            tail.next = current;
            //往前走
            tail = tail.next;
            current = current.next;
        }


        return head;
    }
}
