package cn.bw.sort.heapsort;

public class HeapSort1 {

    public static void sort(int[] data) {

        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(data, i, 0);
            heapify(data, 0, i);
        }

    }

    private static void heapify(int[] data, int cur, int n) {

        int larger = cur;
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;
        while (left < n && data[larger] < data[left]) {
            larger = left;
        }
        while (right < n && data[larger] < data[right]) {
            larger = right;
        }

        if (larger != cur) {
            swap(data, cur, larger);
            heapify(data, larger, n);
        }

    }

    private static void swap(int[] data, int i, int j) {
        data[i] ^= data[j];
        data[j] ^= data[i];
        data[i] ^= data[j];
    }

    private static void swap1(int[] data,int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String... args) {

        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort1.sort(data);

        System.out.println("end");

    }
}
