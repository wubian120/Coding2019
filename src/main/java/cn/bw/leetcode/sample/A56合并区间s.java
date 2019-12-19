package cn.bw.leetcode.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class A56合并区间s {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> tempList = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            //前面一个的 右侧 与 后一个 的左侧 比较
            //后面的左 < 前面的右 则重叠
            if (intervals[i][0] <= right) {
                //如果重叠 就要 在前面的 右 和 后面的右中 选一个大的
                right = Math.max(intervals[i][1], right);
            } else {
                //无重叠
                tempList.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }

        }
        //最后一个 放入。
        tempList.add(new int[]{left,right});
        int[][] result = new int[tempList.size()][2];
        for(int i=0;i<tempList.size();i++){
            result[i] = tempList.get(i);
        }
        return result;
    }

    public static void main(String...args){

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] results = new int[intervals.length][intervals[0].length];
        A56合并区间s a = new A56合并区间s();
        int[][] results = a.merge(intervals);

        System.out.println(results);


    }

}
