package cn.bw.leetcode;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class A239滑动窗口最大值 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null) return new int[]{};
        if(nums.length==0) return new int[0];
        if (k == 1) {
            return nums;
        }

        int max = Integer.MIN_VALUE;
        int len = nums.length;

        int[] results = new int[len - k + 1];
        
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        results[0] = max;

        for (int i = 0; i < len - k; i++) {

            if (max == nums[i]) {
                max = Integer.MIN_VALUE;
                for (int j = i + 1; j < i + 1 + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                    }
                }
            } else if (max < nums[i + k]) {
                max = nums[k + i];
            }
            results[i + 1] = max;
        }

        return results;
    }


}
