package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A215数组中第K大个元素s;
import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ClassName : A215数组中第K个最大元素p
 * @Author : Richard.Wu
 * @Date: 2020-03-16 10:00
 * @Description :
 */

public class A215数组中第K个最大元素p {

    public int findKthLargestHeap(int[] nums, int k) {


        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int v : nums) {

            heap.offer(v);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();

    }


    public int findKthLargestSelect(int[] nums, int k) {

        int len = nums.length;
        return quickSelect(nums, 0, len - 1, len - k);
    }

    private int quickSelect(int[] nums,
                            int left,
                            int right,
                            int ksmall) {
        if (left == right) {
            return nums[left];
        }
        Random rand = new Random();
        int pivotIdx = left + rand.nextInt(right - left);

        pivotIdx = partition(pivotIdx, left, right, nums);
        if (pivotIdx == ksmall) {
            return nums[pivotIdx];
        } else if (pivotIdx < ksmall) {
            return quickSelect(nums, pivotIdx + 1, right, ksmall);
        } else {
            return quickSelect(nums, left, pivotIdx - 1, ksmall);
        }
    }

    private int partition(int idx, int left,
                          int right, int[] nums) {

        int pivot = nums[idx];
        swap(nums, idx, right);

        int cur = left;
        for (int i = cur; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, cur);
                cur++;
            }
        }
        swap(nums, cur, right);
        return cur;
    }


    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 2;

        A215数组中第K个最大元素p a = new A215数组中第K个最大元素p();
        int result = a.findKthLargestHeap(nums, k);

        System.out.println(result);

        System.out.println("end");


    }

}
