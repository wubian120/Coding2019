package cn.bw.leetcode.sample;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A139单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict){

        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        int len = s.length();
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }

}
