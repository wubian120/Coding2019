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


    int [] nums;

    public void swap1(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }


    public int partition1(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap1(store_index, right);

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
            return this.nums[left];  // return that element

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition1(left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargest_QUICK(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(0, size - 1, size - k);
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



    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargestThree(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                break;
//                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

        return nums[target];
    }

    public int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot

        int lt = left + 1;
        int rt = right;

        while (true) {
            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            lt++;
            rt--;
        }

        swap(nums, left, rt);
        return rt;
    }



    /** ---------------------------------------------- */




//    private int[] nums;
    private int k;

    public int findKthLargestTwo(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length - k;
        return select(0, nums.length - 1);
    }

    private int select(int left, int right) {
        int pivot_index = partition(left, right, medium(left, right));
        if (k == pivot_index) {
            return nums[k];
        } else if (k < pivot_index) {
            return select(left, pivot_index - 1);
        } else {
            return select(pivot_index + 1, right);
        }
    }

    private int partition(int left, int right, int pivot_index) {
        int start = left, end = right;
        if (left != pivot_index) {
            swap(left, pivot_index);
        }
        int pivot = nums[left];
        while (start < end) {
            while (start < end && pivot <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    private int medium(int left, int right) {
        int medium = (left + right) / 2;
        if (nums[left] <= nums[medium] && nums[medium] <= nums[right]) {
            return medium;
        } else if (nums[medium] <= nums[left] && nums[left] <= nums[right]) {
            return left;
        } else {
            return right;
        }
    }

    private void swap(int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }


    /**
     * -----------------------------------------------
     **/


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


    public static void main(String[] args){

        int[] nums={3,2,1,5,6,4};

        int k =2;

        A215数组中第K大个元素s a = new A215数组中第K大个元素s();
//        int result = a.findKthLargest(nums,k);
        int result = a.findKthLargestTwo(nums,k);

        System.out.println(result);

        System.out.println("end");

    }


}
