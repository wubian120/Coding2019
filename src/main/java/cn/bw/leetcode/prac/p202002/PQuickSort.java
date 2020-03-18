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

        quickSort(nums, 0, nums.length - 1);

    }

    private static void quickSort(int[] num, int left, int right) {

        if (left > right) return;

        int start = left, end = right;
        int pivot = num[left];

        while (start != end) {

            while (start < end && pivot <= num[end]) {
                end--;
            }

            while (start < end && num[start] <= pivot) {
                start++;
            }

            if (start < end) {
                int t = num[start];
                num[start] = num[end];
                num[end] = t;
            }

        }
        //把中间
        num[left] = num[start];

        num[start] = pivot;

        quickSort(num, left, start - 1);
        quickSort(num, start + 1, right);


    }


    public static void main(String... args) {

        int[] nums = {3, 45, 1, 2, 67, 9, 10, 8, 4, 32};
        PQuickSort.sort(nums);

        System.out.println("end");


    }


}
