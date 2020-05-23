package cn.bw.leetcode.prac.p202002;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : A25k个一组翻转链表p
 * @Author : Richard.Wu
 * @Date: 2020-05-16 15:36
 * @Description :
 */

public class A25k个一组翻转链表p {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode preHead=new ListNode(0);

        ListNode pNode=preHead;

        while (true){
            int count=0;
            ListNode temp=head;
            while (temp!=null&&count<k){
                stack.add(temp);
                temp = temp.next;
                count++;
            }

            if(count!=k){
                pNode.next = head;
                break;
            }

            //翻转
            while (!stack.isEmpty()){
                pNode.next = stack.pollLast();
                pNode = pNode.next;
            }
            pNode.next = temp;
            head = temp;
        }

        return preHead.next;




    }



}
