package cn.bw.leetcode.prac.p202002;


/**
 * @ClassName : A2两数相加p
 * @Author : Richard.Wu
 * @Date: 2020-03-08 09:47
 * @Description :
 */

public class A2两数相加p {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int sum = 0;

        while (l1 != null || l2 != null) {

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            cur.next = new ListNode((v1 + v2 + sum) % 10);
            cur = cur.next;

            sum = (v1 + v2 + sum) / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }


        }

        //最后的 进位
        if (sum > 0) {
            cur.next = new ListNode(sum);
        }
        return pre.next;


    }
}
