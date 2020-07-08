package cn.bw.leetcode.prac.p202002;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : A139单词拆分p
 * @Author : Richard.Wu
 * @Date: 2020-06-25 21:38
 * @Description :
 */

public class A139单词拆分p {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;

        for(int r=1;r<=len;r++){
            for(int l=0;l<r;l++){
                if(dp[l]&&wordSet.contains(s.substring(l,r))){
                    dp[r]=true;
                    break;
                }
            }
        }


        return dp[len];
    }

}
