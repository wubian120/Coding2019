package cn.bw.leetcode.prac.p2019;

import java.util.*;

public class A140单词拆分II {

    public List<String> wordBreak(String s,List<String> wordDict){

        int len = s.length();
        boolean[] dp =new boolean[len];

        Set<String> wordSet = new HashSet<>(wordDict);
        //第一部分 dp  和 139题类似
        //dp[i] 表示 0~i 子字符串是否可以在 wordDict中。
        //双层遍历  j ~ i
        for(int r=0; r<len;r++){
            if(wordSet.contains(s.substring(0,r+1))){
                dp[r]=true;
                continue;
            }
            for(int l=0;l<r;l++){
                if(dp[l]&&wordSet.contains(s.substring(l+1,r+1))){
                    dp[r]=true;

                    break;
                }
            }
        }
        // 处理 字符串
        List<String> result = new LinkedList<>();
        if(dp[len-1]){
            LinkedList<String> queue = new LinkedList<>();
            dfs(s,len-1,wordSet,result,queue,dp);
            return result;
        }

      return result;
    }

    private void dfs(String s,int end, Set<String> wordSet, List<String> result,
                     LinkedList<String> queue, boolean[] dp){

        if(wordSet.contains(s.substring(0,end+1))){
            queue.addFirst(s.substring(0,end+1));

            StringBuilder builder = new StringBuilder();
            for(String w:queue){
                builder.append(w);
                //
                builder.append(" ");
            }
            //删除最后一个 空格
            builder.deleteCharAt(builder.length()-1);
            result.add(builder.toString());

            ///why ?
            queue.removeFirst();

        }

        for(int i=0;i<end;i++){
            if(dp[i]){
                String suffix = s.substring(i+1,end+1);
                if(wordSet.contains(suffix)){
                    queue.addFirst(suffix);
                    dfs(s,i,wordSet,result,queue,dp);
                    queue.removeFirst();
                }
            }
        }


    }

}
