package cn.bw.leetcode.prac.p202002;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : PL480滑动窗口的中位数
 * @Author : Richard.Wu
 * @Date: 2020-03-23 10:12
 * @Description :
 */

public class PL480滑动窗口的中位数 {


    public double[] medianSlidingWindow(int[] nums, int k) {

        int len=nums.length;

        int n = len-k+1;
        double[] results = new double[n];

        PriorityQueue<Integer> small =
                new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Integer> big =
                new PriorityQueue<>();

        for(int i=0;i<len;i++){
            int toAdd=nums[i];

            if(small.isEmpty()|| small.peek()<toAdd){
                big.offer(toAdd);
            }else {
                small.offer(toAdd);
            }

            while (small.size()>(big.size()+1)){
                big.offer(small.poll());
            }

            while (big.size()>small.size()){
                small.offer(big.poll());
            }

            if(i-k+1>=0){
                int toRemove=nums[i-k+1];

                results[i-k+1]=
                        small.size()==big.size()?
                                0.5*((long)small.peek()+(long)big.peek()):
                                small.peek();

                if(toRemove<=small.peek()){
                    small.remove(toRemove);
                }else {
                    big.remove(toRemove);
                }
            }


        }

        return results;




    }

}
