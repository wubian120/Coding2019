package cn.bw.sort.heapsort;

public class HeapSort4 {

    public static void sort(int[] nums){
        int len = nums.length;
        for(int i=len/2 -1;i>=0;i--){
            heapify(nums,i,len);
        }

        for(int i=len-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,0,i);
        }

    }

    private static void heapify(int[] data, int cur, int n){
        int larger = cur;
        int left = 2 * cur +1;
        int right = 2 * cur +2;

        while (left < n && data[larger]<data[left]){
            larger = left;
        }

        while (right < n && data[larger] < data[right]){
            larger = right;
        }

        if(larger != cur){
            swap(data, cur, larger);
            heapify(data, larger, n);
        }
    }


    private static void swap(int[] d, int i, int j){
        int t = d[i];
        d[i] = d[j];
        d[j] = t;
    }

    public static void main(String... args) {

        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort4.sort(data);

        System.out.println("end");

    }
}
