package cn.bw.sort.heapsort;

public class HeapSort2 {
    /**
     * 1.
     *
     * @param data
     */
    public static void sort(int[] data) {

        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapify(data, 0, i);
        }

    }

    private static void heapify(int[] data, int cur, int n) {
        int larger = cur;
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;

        while (left < n && data[larger] < data[left]) {
            larger = left;
        }

        while (right < n && data[larger] < data[right]) {
            larger = right;
        }

        if (cur != larger) {
            swap(data, larger, cur);
            heapify(data, larger, n);
        }

    }

    private static void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String... args) {

        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort2.sort(data);

        System.out.println("end");

    }

}
