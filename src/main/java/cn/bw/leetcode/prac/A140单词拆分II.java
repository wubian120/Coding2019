package cn.bw.leetcode.prac;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A140单词拆分II {

    public List<String> wordBreak(String s,List<String> wordDict){

        Map<String,List<String>> wordMap = new HashMap<>();
        if(wordMap.containsKey(s)){
            return wordMap.get(s);
        }

        List<String> result = new LinkedList<>();
        if(0==s.length()){
            result.add("");
            return result;
        }
        for(String word:wordDict){
//            List<String> subResult =
        }

        return null;

    }

}
