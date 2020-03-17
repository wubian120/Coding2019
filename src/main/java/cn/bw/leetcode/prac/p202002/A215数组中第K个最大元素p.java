package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A215数组中第K大个元素s;

/**
 * @ClassName : A215数组中第K个最大元素p
 * @Author : Richard.Wu
 * @Date: 2020-03-16 10:00
 * @Description :
 */

public class A215数组中第K个最大元素p {

    public int findKthLargest(int[] nums, int k) {

        k = nums.length-k;
        return select(nums,k,0,nums.length-1);

    }

    private int select(int[] nums, int k, int left, int right) {
        int mid = middle(nums,left,right);
        int pivot = partition(nums,left,right,mid);
        if(k==pivot){
            return nums[k];
        }else if(k<pivot){
            return select(nums,k,left,pivot-1);
        }else {
            return select(nums,k,pivot+1,right);
        }

    }


    private int partition(int[] nums, int left, int right, int pivot) {

        int start = left, end = right;
        if (left != pivot) {
            swap(nums, left, pivot);
        }

        int p = nums[left];
        while (start < end) {
            while (start < end && p <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= p) {
                start++;
            }

            nums[end]=nums[start];
        }
        nums[start]=p;
        return start;

    }

    private int middle(int[] nums, int left, int right) {
        int middle = (left + right) / 2;
        if (nums[left] <= nums[middle] && nums[middle] <= nums[right]) {
            return middle;
        } else if (nums[middle] <= nums[left] && nums[left] <= nums[right]) {
            return left;
        } else {
            return right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args){

        int[] nums={3,2,1,5,6,4};

        int k =2;

        A215数组中第K个最大元素p a = new A215数组中第K个最大元素p();
        int result = a.findKthLargest(nums,k);

        System.out.println("end");


    }

}
