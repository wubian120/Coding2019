package cn.bw.leetcode.sample;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : A480滑动窗口的中位数s
 * @Author : Richard.Wu
 * @Date: 2020-03-22 11:46
 * @Description :
 */

public class A480滑动窗口的中位数s {

    public double[] medianSlidingWindow(int[] nums, int k) {

        //大顶堆
        PriorityQueue<Integer> small
                = new PriorityQueue<>(Comparator.reverseOrder());
        //小顶堆
        PriorityQueue<Integer> big = new PriorityQueue<>();

        int len = nums.length;
        // 结果的个数
        int n = len - k + 1;

        double[] results = new double[n];

        for (int i = 0; i < len; i++) {
            int toAdd = nums[i];
            if (small.isEmpty() || small.peek() < toAdd) {
                big.offer(toAdd);
            } else {
                small.offer(toAdd);
            }

            while (small.size() > big.size() + 1) {
                big.offer(small.poll());
            }

            while (small.size() < big.size()) {
                small.offer(big.poll());
            }
            if (i - k + 1 >= 0) {
                results[i - k + 1] =
                        small.size() == big.size() ?
                                0.5 * ((long) small.peek() + (long) big.peek()) :
                                small.peek();

                int toRemove = nums[i - k + 1];
                if (toRemove <= small.peek()) {
                    small.remove(toRemove);
                } else {
                    big.remove(toRemove);
                }
            }

        }

        return results;

    }


    public static void main(String...args){

        int[] nums= {1,3,-1,-3,5,3,6,7}; int k = 3;
        A480滑动窗口的中位数s a = new A480滑动窗口的中位数s();
        double[] results = a.medianSlidingWindow(nums,k);

        priorityQueueTest();


        System.out.println("end");


    }


    public static void priorityQueueTest(){

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<10;i++){
            pq.offer(i);
        }


        for(int i=0;i<10;i++){
            System.out.println(pq.poll());
        }



    }


}
