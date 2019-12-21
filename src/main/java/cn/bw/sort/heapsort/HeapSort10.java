package cn.bw.sort.heapsort;

public class HeapSort10 {

    public static void sort(int[] data) {

        int len = data.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(data,i,len);
        }

        for(int i=len-1;i>=0;i--){
            swap(data,0,i);
            heapify(data,0,i);
        }
    }

    private static void heapify(int[] d, int cur, int n) {
        int larger = cur;
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        while (left<n && d[larger]<d[left]){
            larger = left;
        }

        while (right<n && d[larger] < d[right]){
            larger = right;
        }
        if(larger != cur){
            swap(d,cur, larger);
            heapify(d,larger,n);
        }
    }

    private static void swap(int[] d, int i, int j) {
        int t = d[i];
        d[i] = d[j];
        d[j] = t;
    }

    public static void main(String... args) {

        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort10.sort(data);

        System.out.println("end");

    }
}