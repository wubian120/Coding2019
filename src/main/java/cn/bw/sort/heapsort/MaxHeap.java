package cn.bw.sort.heapsort;

public class MaxHeap {

    private int[] data;
    private int capacity;

    public MaxHeap() {
    }

    public MaxHeap(int[] data) {
        buildMaxHeap(data);
    }

    private int parentInx(int i) {
        return (i - 1) / 2;
    }

    private int leftInx(int i) {
        return 2 * i + 1;
    }


    private void maxHeapify(int i) {

    }


    private void buildMaxHeap(int[] data) {

    }
}
