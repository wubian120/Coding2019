package cn.bw.leetcode.sample;

public class A62不同路径s {

    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }

        int[] paths= new int[n];
        paths[0]=1;

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                paths[j] += paths[j-1];
            }
        }


        return paths[n-1];

    }

}
