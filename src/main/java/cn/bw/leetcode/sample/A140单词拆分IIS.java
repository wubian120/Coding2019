package cn.bw.leetcode.sample;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class A140单词拆分IIS {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }


    public static void main(String...args){

        String s = "catsanddog";
        String[] wordDick = {"cat", "cats", "and", "sand", "dog"};

        Set wordDickSet = new HashSet();
        for(String s1: wordDick){
            wordDickSet.add(s1);
        }

        A140单词拆分IIS a = new A140单词拆分IIS();
        List<String> results = a.wordBreak(s,wordDickSet);

        results.stream().forEach(System.out::println);
    }
}
