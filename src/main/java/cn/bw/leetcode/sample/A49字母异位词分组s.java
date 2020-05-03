package cn.bw.leetcode.sample;

import java.util.*;

/**
 * @ClassName : A49字母异位词分组s
 * @Author : Richard.Wu
 * @Date: 2020-05-03 15:16
 * @Description :
 *
 * @思路：
 *
 *  每个词 按照 字母顺序排序， eat,  tea， 都变成 aet。
 *
 *
 */

public class A49字母异位词分组s {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> wordsMap=new HashMap<>();
        for(String word :strs){

            char[] wordChars=word.toCharArray();
            //词的 字符数组 排序
            Arrays.sort(wordChars);

            // key是词的  字母序str
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
