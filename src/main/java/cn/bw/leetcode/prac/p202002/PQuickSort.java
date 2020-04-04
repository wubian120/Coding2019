package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : PQuickSort
 * @Author : Richard.Wu
 * @Date: 2020-03-17 16:15
 * @Description :
 */

public class PQuickSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        quickSort(nums,0,nums.length-1);

    }

    private static void quickSort(int[] nums, int left, int right){
        if(left>right)return;

        int pivot = nums[left];

        int start = left, end=right;

        while (start!=end){
            while (start<end && pivot<=nums[end]){
                end--;
            }

            while (start<end && nums[start]<=pivot){
                start++;
            }

            if(start<end){
                int t = nums[start];
                nums[start]=nums[end];
                nums[end]=t;
            }
        }

        nums[left]=nums[start];
        nums[start]=pivot;

        quickSort(nums,left, start-1);
        quickSort(nums,start+1, right);
    }








    public static void main(String... args) {

        int[] nums = {3, 45, 1, 2, 67, 9, 10, 8, 4, 32};
        PQuickSort.sort(nums);

        System.out.println("end");


    }


}
