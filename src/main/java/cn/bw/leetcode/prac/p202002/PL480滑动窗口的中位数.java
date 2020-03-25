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

        PriorityQueue<Integer> smaller
                = new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Integer> bigger = new PriorityQueue<>();

        int len = nums.length;
        int n = len - k + 1;

        double[] results = new double[n];

        for (int i = 0; i < len; i++) {

            if (smaller.isEmpty() || smaller.peek() < nums[i]) {
                bigger.offer(nums[i]);
            } else {
                smaller.offer(nums[i]);
            }

            while (smaller.size() > bigger.size() + 1) {
                bigger.offer(smaller.poll());
            }

            while (bigger.size() > smaller.size()) {
                smaller.offer(bigger.poll());
            }


            if (i - k + 1 >= 0) {

                if (smaller.size() == bigger.size()) {
                    results[i - k + 1] = 0.5 * ((long)smaller.peek() + (long)bigger.peek());
                } else {
                    results[i - k + 1] = smaller.peek();
                }

                int toRemove = nums[i-k+1];
                if(toRemove<=smaller.peek()){
                    smaller.remove(toRemove);
                }else {
                    bigger.remove(toRemove);
                }


            }

        }

        return results;
    }

}
