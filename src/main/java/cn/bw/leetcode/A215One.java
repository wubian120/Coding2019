package cn.bw.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/submissions/
 */
public class A215One {

    /***
     * 优先队列
     */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1 - i2);

        for(int n : nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }

    /**
     * quickselect
     * @param nums
     * @param k
     * @return
     */




    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1 - i2);

        for(int n : nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
