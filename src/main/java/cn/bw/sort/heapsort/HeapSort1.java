package cn.bw.sort.heapsort;

public class HeapSort1 {


    public static void heapSort(int[] nums) {

        int len=nums.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(nums,i,len);
        }

        for(int i=len-1;i>=0;i--){
            swap(nums,0,i);
            heapify(nums,0,i);
        }


    }

    private static void heapify(int[] nums, int cur, int end) {

        int bigger = cur;
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;

        while (left<end&& nums[bigger]<nums[left]){
            bigger=left;
        }
        while (right<end && nums[bigger]<nums[right]){
            bigger=right;
        }

        if(bigger!=cur){
            swap(nums, bigger,cur);
            heapify(nums,bigger,end);
        }

    }


    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String... args) {

        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort1.heapSort(data);

        System.out.println("end");

    }
}
