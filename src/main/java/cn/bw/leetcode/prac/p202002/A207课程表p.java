package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : A207课程表p
 * @Author : Richard.Wu
 * @Date: 2020-06-06 21:54
 * @Description :
 */

public class A207课程表p {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];

        for(int[] pre:prerequisites){
            indegrees[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.offer(i);
            }
        }


        while (!queue.isEmpty()){

            int course = queue.poll();


            numCourses--;
            for(int[] pre:prerequisites){
                if(pre[1]!=course){
                    continue;
                }
                indegrees[pre[0]]--;
                if(indegrees[pre[0]]==0){
                    queue.offer(pre[0]);
                }

            }

        }
        return numCourses==0;


    }
}
