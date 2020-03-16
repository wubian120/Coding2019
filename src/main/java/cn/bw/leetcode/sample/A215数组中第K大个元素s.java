package cn.bw.leetcode.sample;

/**
 * @ClassName : A215数组中第K大个元素s
 * @Author : Richard.Wu
 * @Date: 2020-03-13 08:57
 * @Description :
 */

public class A215数组中第K大个元素s {


    int[] nums;

    public int findKthLargest_Two(int[] nums, int k) {



        return 0;
    }


    public int quickSelect(int left, int right, int k_smallest){


        return 0;
    }



/**    ----------------------------------------------- **/


    public int findKthLargest(int[] nums, int k) {
        k--;
        int lower = 0, higher = nums.length - 1, pivot = 0;
        while (lower <= higher) {
            pivot = part(nums, lower, higher);
            if (pivot == k) {
                break;
            } else if (pivot < k) {
                lower = pivot + 1;
            } else {
                higher = pivot - 1;
            }
        }
        return nums[k];
    }

    private int part(int[] nums, int lower, int higher) {
        int pivot = lower + (higher - lower) / 2;
        while (lower < higher) {

            while (lower < pivot && nums[pivot] <= nums[lower]) {
                lower++;
            }
            while (higher > pivot && nums[higher] <= nums[pivot]) {
                higher--;
            }

            if (lower != higher) {
                swap(nums, lower, higher);
            }

            if (pivot == lower) {
                pivot = higher;
            } else if (pivot == higher) {
                pivot = lower;
            } else {
                lower++;
                higher--;
            }

        }
        return pivot;
    }

    public void swap(int[] data, int i, int j) {
//        int temp = data[i];
//        data[i] = data[j];
//        data[j] = temp;

        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }


}
