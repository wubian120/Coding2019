package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A142环形链表IIs;

/**
 * @ClassName : A142环形链表IIp
 * @Author : Richard.Wu
 * @Date: 2020-04-25 16:55
 * @Description :
 */

public class A142环形链表IIp {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode fast=head,slow = head;

        while (fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }

        if(fast==null|| fast.next==null){
            return null;
        }

        slow=head;

        while (fast!=slow){
            fast=fast.next;
            slow = slow.next;
        }
        return fast;

    }

}
