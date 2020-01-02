package cn.bw.leetcode.prac;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * dp解法：
 * dp[i] 表示 0-i 是否可以用字典中 单词构成。
 * 双层循环 遍历  s[j:i]
 *
 */
public class A139单词拆分r {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0]=true;

        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&& wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
        
    }

}
