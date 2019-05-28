package cn.bw.sort.heapsort;

public class QuickSort {

    public static void sort(int[] nums) {


    }



    private void swap(int[] d, int i, int j) {
        d[i] = d[i] ^ d[j];
        d[j] = d[i] ^ d[j];
        d[i] = d[i] ^ d[j];
    }

    public static void main(String... args) {

        int[] nums = {11, 5, 6, 3, 2, 19, 2, 3, 54, 3, 2, 8, 1};


    }

}
