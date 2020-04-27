package cn.bw.leetcode.sample;

/**
 * @ClassName : A142环形链表IIs
 * @Author : Richard.Wu
 * @Date: 2020-04-25 16:46
 * @Description :
 *
 * 快慢指针
 *
 */

public class A142环形链表IIs {

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

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
