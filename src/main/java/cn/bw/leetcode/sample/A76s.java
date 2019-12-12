package cn.bw.leetcode.sample;

/**
 * 76.最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class A76s {
    public String minWindow(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] tMap = new int[128];

        int right = 0, left = 0;
        //计数
        int count = tchars.length;
        int slen = s.length();
        int minLen = s.length() + 1;

        int l = 0, r = 0;

        for (char c : tchars) {
            tMap[c]++;
        }

        while (right < slen) {
            if (tMap[schars[right]] > 0) {
                count--;
            }
            tMap[schars[right]]--;
            right++;

            //计数为0， 此时 [right，left-1]包含一个解
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    l = left;
                    r = right;
                }

                //从右开始移动 窗口
                tMap[schars[left]]++;
                if (tMap[schars[left]] > 0) {
                    count++;
                }
                left++;
            }

        }

        return minLen == slen + 1 ? "" : s.substring(l, r);
    }
}
