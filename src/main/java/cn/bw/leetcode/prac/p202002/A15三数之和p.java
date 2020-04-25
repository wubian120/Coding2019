package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A15三数之和p
 * @Author : Richard.Wu
 * @Date: 2020-03-13 23:56
 * @Description :
 * <p>
 * 2020-04-25
 */

public class A15三数之和p {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1, high = len - 1, sum = 0 - nums[i];

                while (low < high) {

                    if ((nums[low] + nums[high]) == sum) {

                        results.add(Arrays.asList(nums[low], nums[high], nums[i]));

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        high--;
                        low++;

                    } else if ((nums[low] + nums[high]) > sum) {
                        high--;
                    } else {
                        low++;
                    }

                }

            }

        }


        return results;
    }

}
