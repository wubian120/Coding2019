package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A56合并区间p
 * @Author : Richard.Wu
 * @Date: 2020-04-17 23:00
 * @Description :
 */

public class A56合并区间p {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        List<int[]> curList = new LinkedList<>();
        int left = intervals[0][0], right = intervals[0][1];
        int len = intervals.length;
        for (int i = 0; i < len; i++) {

            if (intervals[i][0] <= right) {
                right = Math.max(intervals[i][1], right);
            } else {
                curList.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        curList.add(new int[]{left,right});

        int[][] results=new int[curList.size()][2];

        for(int i=0;i<curList.size();i++){
            results[i]=curList.get(i);
        }

        return results;
        

    }


}
