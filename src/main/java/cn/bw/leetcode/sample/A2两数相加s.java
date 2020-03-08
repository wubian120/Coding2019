package cn.bw.leetcode.sample;

/**
 * @ClassName : A2两数相加s
 * @Author : Richard.Wu
 * @Date: 2020-03-08 09:31
 * @Description :
 * <p>
 * leetcode  2.两数相加
 */

public class A2两数相加s {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null ? 0 : l1.val);
            int y = (l2 == null ? 0 : l2.val);

            current.next = new ListNode((x + y + sum) % 10);
            current = current.next;

            sum = (x + y + sum) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //进位
        if (sum > 0) {
            current.next = new ListNode(sum);
        }
        return head.next;
    }
}
