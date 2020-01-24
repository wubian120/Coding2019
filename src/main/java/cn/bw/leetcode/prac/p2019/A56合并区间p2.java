package cn.bw.leetcode.prac.p2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/***
 * leetcode 56 合并区间
 * 1.判空，
 * 2. Arrays sort
 * 3. left, right
 * 4.新建一个 临时的list
 * 5.循环 intervals， 判断是否重叠，如果 i个 数组的第二个元素 小于 right
 * 6.如果不重叠 ，则把left，right 放入temp
 * 7. 循环外面 再次 放入最后一个 left,right
 * 8. 把 templist 变为 int[][] 返回。
 *
 */

public class A56合并区间p2 {

    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0){
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
        int left=intervals[0][0], right=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=right){
                right = Math.max(intervals[i][1],right);

            }else {
                tempList.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        tempList.add(new int[]{left,right});
        int[][] result =new int[tempList.size()][2];
        for(int i=0;i<tempList.size();i++){
            result[i]=tempList.get(i);
        }
        return result;

    }

}
