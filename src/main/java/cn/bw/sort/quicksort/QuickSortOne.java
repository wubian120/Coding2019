package cn.bw.sort.quicksort;

public class QuickSortOne {

    public static void sort(int[] numbers){

        quickSort(numbers,0,numbers.length-1);
    }

    private static void quickSort(int[] data, int start, int end){

        if(start >= end){
            return;
        }
        int s=start, e = end;
        int m = start + (end-start)/2;
        int pivot = data[m];

        while (s<e){

            while (data[s] < pivot){
                s++;
            }
            while (pivot < data[e]){
                e--;
            }

            if(s<=e){
                int t = data[s];
                data[s] = data[e];
                data[e] = t;
//                swap(data,s,e);
                s++;
                e--;
            }

            if(s<end){
                quickSort(data,s,end);
            }

            if(start< e){
                quickSort(data,start,e);
            }

        }

    }

    public static void swap(int[] d, int i, int j) {
        d[i] = d[i] ^ d[j];
        d[j] = d[i] ^ d[j];
        d[i] = d[i] ^ d[j];
    }

    public static void main(String...args){

        int[] nums = {11, 5, 6, 3, 2, 19};

        QuickSortOne.sort(nums);

//        QuickSortOne.swap(nums,1,2);

        System.out.println("end");

    }

}
