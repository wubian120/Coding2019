package cn.bw.sort.quicksort;

public class QuickSortOne {

    public static void sort(int[] numbers) {

        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] data, int start, int end) {

        if (start >= end) {
            return;
        }
        int s = start, e = end;
        int m = start + (end - start) / 2;
        int pivot = data[m];

        while (s < e) {

            while (data[s] < pivot) {
                s++;
            }
            while (pivot < data[e]) {
                e--;
            }

            if (s <= e) {
                int t = data[s];
                data[s] = data[e];
                data[e] = t;
//                swap(data,s,e);
                s++;
                e--;
            }

            if (s < end) {
                quickSort(data, s, end);
            }

            if (start < e) {
                quickSort(data, start, e);
            }

        }

    }

    public static void swap(int[] d, int i, int j) {
        d[i] = d[i] ^ d[j];
        d[j] = d[i] ^ d[j];
        d[i] = d[i] ^ d[j];
    }

    public static void main(String... args) {

        int[] nums = {11, 5, 99, 89, 1019, 78, 6, 3, 2, 19, 1, 4, 7, 14, 8, 9, 19, 12, 13, 15, 22, 101, 18, 222, 2222, 333, 109, 17, 222, 123, 123,
                123, 4, 5, 32, 12, 3, 4, 5, 5, 62324, 2342, 1231, 56, 53, 12, 12, 3, 45, 56, 78, 88, 90, 123,11,234,556,778,223,122,344,56,34,23,45,12,
                12,2,3,4,0,9,87,40,12,21,22,112,345,234,234,12,11,32,123,909,12313,4143,1232,12323,231,123,32,123
        };

//        long current = System.currentTimeMillis();


        long current = System.nanoTime();
        QuickSortOne.sort(nums);

        long end = System.nanoTime();



        long cost = (end - current);


        System.out.println("1cost :" + cost);

        current = System.nanoTime();
        QuickSortTwo.sort(nums);
        end = System.nanoTime();
        cost = (end - current);
        System.out.println("2cost :" + cost);
//        QuickSortOne.swap(nums,1,2);

        System.out.println("end");

    }

}
