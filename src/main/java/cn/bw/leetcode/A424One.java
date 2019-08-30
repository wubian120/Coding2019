package cn.bw.leetcode;

public class A424One {

    public int characterReplacement(String s, int k) {
        //right窗口右侧，left窗口左侧，cur当前重复字符最长数
        int result=0, right=0,left=0,cur=0;
        int len = s.length();
        int[] count = new int[26];
        while (right<len){

            int index = s.charAt(right)-'A';
            count[index]++;

            cur = Math.max(cur,count[index]);
            while (right-left+1-cur > k){
                count[s.charAt(left++)-'A']--;
            }

            result = Math.max(right-left+1,result);
            right++;
        }

        return result;
    }
}
