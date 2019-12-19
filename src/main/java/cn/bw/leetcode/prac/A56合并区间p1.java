package cn.bw.leetcode.prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class A56合并区间p1 {

    public int[][] merge(int[][] intervals){
        if(intervals==null ||intervals.length==0){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        List<int[]> tempList = new LinkedList<>();
        int left = intervals[0][0], right=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(right >= intervals[i][0]){
                right = Math.max(intervals[i][1],right);
            }else {
                tempList.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        tempList.add(new int[]{left,right});
        int[][] result = new int[tempList.size()][2];
        for(int i=0;i<tempList.size();i++){
            result[i]= tempList.get(i);

        }
        return result;
    }

}
