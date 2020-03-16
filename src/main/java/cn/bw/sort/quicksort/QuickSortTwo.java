package cn.bw.sort.quicksort;

/**
 * @ClassName : QuickSortTwo
 * @Author : Richard.Wu
 * @Date: 2020-03-14 13:20
 * @Description :
 */

public class QuickSortTwo {

    public static void sort(int[] nums) {

        if(nums==null||nums.length==0){
            return;
        }

        quickSort(nums,0,nums.length-1);

    }


    public static void quickSort(int[] nums, int left, int right) {

        if (left > right) return;

        int pivot = nums[left];
        int start = left, end = right;
        while (start != end) {

            while (start < end && pivot <= nums[end]) {
                end--;
            }

            while (start < end && nums[start] <= pivot) {
                start++;
            }

            if (start < end) {
                //交换 start, end
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

        nums[left] = nums[start];
        nums[start] = pivot;

        quickSort(nums, left, start - 1);
        quickSort(nums, start + 1, right);

    }


}
