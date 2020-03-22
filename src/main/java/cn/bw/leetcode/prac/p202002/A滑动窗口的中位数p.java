package cn.bw.leetcode.prac.p202002;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : A滑动窗口的中位数p
 * @Author : Richard.Wu
 * @Date: 2020-03-22 12:57
 * @Description :
 */

public class A滑动窗口的中位数p {


    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> smaller =
                new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Integer> bigger = new PriorityQueue<>();

        int len = nums.length;
        int resultLen = len - k + 1;

        double[] results= new double[resultLen];

        for(int i=0;i<len;i++){

            int curItem=nums[i];
            if(smaller.isEmpty()||smaller.peek()<curItem){
                bigger.offer(curItem);
            }else {
                smaller.offer(curItem);
            }

            while (smaller.size()>bigger.size()+1){
                bigger.offer(smaller.poll());
            }

            while (bigger.size()>smaller.size()){
                smaller.offer(bigger.poll());
            }

            int idx=i-k+1;
            if(idx>=0){

                if(smaller.size()==bigger.size()){
                    results[idx] = 0.5 * ((long)smaller.peek()+(long)bigger.peek());
                }else {
                    results[idx]=smaller.peek();
                }

                int itemRemove=nums[idx];
                if(itemRemove<=smaller.peek()){
                    smaller.remove(itemRemove);
                }else {
                    bigger.remove(itemRemove);
                }

            }

        }

        return results;


    }


}
