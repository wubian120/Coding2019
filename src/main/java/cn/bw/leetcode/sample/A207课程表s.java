package cn.bw.leetcode.sample;

import java.util.LinkedList;

/**
 * @ClassName : A207课程表s
 * @Author : Richard.Wu
 * @Date: 2020-06-06 21:53
 * @Description :
 */

public class A207课程表s {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];

        for(int[] cp : prerequisites){
            indegrees[cp[0]]++;
        }

        LinkedList<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            Integer course = queue.poll();

            numCourses--;
            for(int[] pre:prerequisites){
                if(pre[1]!= course){
                    continue;
                }
                --indegrees[pre[0]];
                if(indegrees[pre[0]]==0){
                    queue.offer(pre[0]);
                }
            }

        }

        return numCourses==0;
    }


}
