package cn.bw.leetcode.prac.p202002;


import java.util.List;

/**
 * @ClassName : A21合并两个有序链表p
 * @Author : Richard.Wu
 * @Date: 2020-03-20 11:41
 * @Description :
 */

public class A21合并两个有序链表p {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pre=new ListNode(0);
        ListNode cur = pre;

        while (l1!=null&&l2!=null){

            if(l1.val<=l2.val){
                cur.next=new ListNode(l1.val);
                l1=l1.next;
            }else {
                cur.next=new ListNode(l2.val);
                l2=l2.next;
            }


            cur = cur.next;
        }

        while (l1!=null){
            cur.next=new ListNode(l1.val);
            cur=cur.next;
            l1=l1.next;
        }

        while (l2!=null){
            cur.next= new ListNode(l2.val);
            cur=cur.next;
            l2=l2.next;
        }


        return pre.next;

    }

}
