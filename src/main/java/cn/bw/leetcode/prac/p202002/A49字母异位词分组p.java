package cn.bw.leetcode.prac.p202002;

import java.util.*;

/**
 * @ClassName : A49字母异位词分组p
 * @Author : Richard.Wu
 * @Date: 2020-05-03 15:27
 * @Description :
 */

public class A49字母异位词分组p {

    public List<List<String>> groupAnagrams(String[] strs) {

       HashMap<String,List<String>> wordkeyMap=new HashMap<>();

       for(String word:strs){

           char[] wordChar=word.toCharArray();
           Arrays.sort(wordChar);

           String key=String.valueOf(wordChar);

           if(wordkeyMap.containsKey(key)){
               wordkeyMap.get(key).add(word);
           }else {
               List<String> words=new LinkedList<>();
               words.add(word);
               wordkeyMap.put(key,words);
           }

       }

       return new LinkedList<>(wordkeyMap.values());

    }
}
