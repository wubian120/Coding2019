package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;

/**
 * @ClassName : A547朋友圈p
 * @Author : Richard.Wu
 * @Date: 2020-05-10 08:33
 * @Description :
 */

public class A547朋友圈p {


    public int findCircleNum(int[][] M) {

        int len=M.length;
        int[] parent = new int[len];
        Arrays.fill(parent,-1);

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(M[i][j]==1&& (i!=j)){
                    union(parent,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1){
                count++;
            }
        }
        return count;
    }

    private int find(int[] parent, int i){
        if(parent[i]==-1){
            return i;
        }
        return find(parent, parent[i]);

    }
    private void union(int[] parent, int x, int y){

        int xp = find(parent,x);
        int yp = find(parent,y);
        if(xp!=yp){
            parent[xp]=yp;
        }
    }




}
