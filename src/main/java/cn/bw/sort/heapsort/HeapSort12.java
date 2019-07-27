package cn.bw.sort.heapsort;

public class HeapSort12 {

    public static void sort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }

    }

    private static void heapify(int[] d, int cur, int len) {
        int larger = cur;
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;

        while (left < len && d[larger] < d[left]) {
            larger = left;
        }

        while (right < len && d[larger] < d[right]) {
            larger = right;
        }

        if (larger != cur) {
            swap(d, cur, larger);
            heapify(d,larger,len);
        }

    }

    private static void swap(int[] d, int i, int j) {
        int t = d[i];
        d[i] = d[j];
        d[j] = t;
    }

    public static void main(String... args) {

        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort12.sort(data);

        System.out.println("end");

    }
}
