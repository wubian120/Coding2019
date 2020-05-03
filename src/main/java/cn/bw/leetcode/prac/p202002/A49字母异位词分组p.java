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

        HashMap<String, List<String>> wordsMap=new HashMap<>();
        for(String word :strs){

            char[] wordChars=word.toCharArray();
            Arrays.sort(wordChars);

            String wordKey=String.valueOf(wordChars);

            if(wordsMap.containsKey(wordKey)){
                wordsMap.get(wordKey).add(word);
            }else {
                List<String> wordList=new ArrayList<>();
                wordList.add(word);
                wordsMap.put(wordKey,wordList);
            }

        }
        return new LinkedList<>(wordsMap.values());


    }
}
