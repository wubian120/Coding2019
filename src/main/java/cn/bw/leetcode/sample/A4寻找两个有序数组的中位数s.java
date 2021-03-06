package cn.bw.leetcode.sample;

/**
 * @ClassName : A4寻找两个有序数组的中位数s
 * @Author : Richard.Wu
 * @Date: 2020-04-22 21:43
 * @Description :
 * @思路
 *
 * 求 k 小的一种特殊情况。
 * 找到 第k小， 每次排除一半。
 *
 *
 */

public class A4寻找两个有序数组的中位数s {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;

        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;


    }

    private int getKth(int[] nums1, int start1, int end1,
                       int[] nums2, int start2, int end2,
                       int k) {

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {2, 4};

    }


}
