package cn.bw.leetcode.sample;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ClassName : A215数组中第K大个元素s
 * @Author : Richard.Wu
 * @Date: 2020-03-13 08:57
 * @Description :
 */

public class A215数组中第K大个元素s {


    // 快速选择 解法

    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        return quickSelect(nums, 0, len - 1, len - k);


    }


    private int quickSelect(int[] nums, int left, int right, int kSmallest) {

        if (right == left) {
            return nums[left];
        }

        Random random = new Random();
        int pivotIdx = left + random.nextInt(right - left);

        pivotIdx = partition(nums, left, right, pivotIdx);

        if (kSmallest == pivotIdx) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIdx) {
            return quickSelect(nums, left, pivotIdx - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIdx + 1, right, kSmallest);
        }

    }

    private int partition(int[] nums, int left, int right, int pivotIdx) {
        int pivot = nums[pivotIdx];

        swap(nums, pivotIdx, right);
        int idx = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, idx, i);
                idx++;
            }
        }

        swap(nums, idx, right);

        return idx;

    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }






//    ------------------------------------------------------------

    /// 堆解法



    public int findKthLargestHeap(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>(Comparator.reverseOrder());

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }










    //---------------------------------------------------






    public static void main(String[] args){

        int[] nums={3,2,1,5,6,4};

        int k =2;

        A215数组中第K大个元素s a = new A215数组中第K大个元素s();
        int result = a.findKthLargestHeap(nums,k);
//        int result = a.findKthLargestTwo(nums,k);

//        System.out.println(result);

        System.out.println("end");

    }


}
