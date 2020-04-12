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

        PriorityQueue<Integer> queue
                = new PriorityQueue<>();

        for(int i:nums){
            queue.add(i);

            if(queue.size()>k){
                queue.poll();
            }
        }


        return queue.poll();


    }


    public int findKthLargestSelect(int[] nums, int k) {
       int len = nums.length;

       return quickSelect(nums,0,len-1,len-k);
    }

    private int quickSelect(int[] nums, int left, int right, int ksmall){
        if(left==right){
            return nums[left];
        }

        Random random = new Random();
        int pivotIdx = left+random.nextInt(right-left);

        pivotIdx = partition(nums,left,right,pivotIdx);

        if(pivotIdx==ksmall){
            return nums[pivotIdx];
        }else if(pivotIdx>ksmall){
            return quickSelect(nums,left,pivotIdx-1,ksmall);
        }else {
            return quickSelect(nums,pivotIdx+1,right,ksmall);
        }
    }

    private int partition(int[] nums,
                          int left, int right,
                          int pivotIdx){

        int pivot = nums[pivotIdx];

        swap(nums,pivotIdx,right);

        int idx = left;
        for(int i=left;i<=right;i++){
            if(nums[i]<pivot){
                swap(nums,i,idx);
                idx++;
            }
        }

        swap(nums,idx,right);
        return idx;
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
