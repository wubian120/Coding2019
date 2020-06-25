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

        Set<String> wordSet = new HashSet<>();
        int len=s.length();

        boolean[] dp = new boolean[len+1];
        dp[0]=true;

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
