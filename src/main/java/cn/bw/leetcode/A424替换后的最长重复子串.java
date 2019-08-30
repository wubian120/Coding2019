package cn.bw.leetcode;

public class A424替换后的最长重复子串 {

    public int characterReplacement(String s, int k) {
        int[] hash = new int[128];
        int lo = 0, cnt = 0, res = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt = Math.max(cnt, ++hash[s.charAt(i)]);
            while(i - lo + 1 - cnt > k) hash[s.charAt(lo++)]--;
            res = Math.max(res, i - lo + 1);
        }
        return res;
    }

    public static void main(String...args){

        String s = "ABAB";
        int k = 2;

        A424替换后的最长重复子串 a = new A424替换后的最长重复子串();
        int result = a.characterReplacement1(s,k);

        System.out.println(result);

    }


    /**
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement1(String s, int k) {

        int max = 0, start = 0, end = 0, cur = 0;
        int[] count = new int[26];
        //遍历 s, 先从end开始， 再遍历start。
        while (end < s.length()) {
            //求 end字母的位置。
            int index = s.charAt(end) - 'A';
            //记录 end字符的 出现次数。
            count[index]++;
            //求当前最大重复字符数
            cur = Math.max(cur, count[index]);
            //end-start+1 是 窗口长度， 再减cur 就是非重复的，可以替换的 字母数
            while (end - start + 1 - cur > k){
                //开始替换
//                int startIndex = s.charAt(start)-'A';
//                startIndex++;
//                count[startIndex]--;
                count[s.charAt(start) - 'A']--;
                start++;
            }


            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;

    }

    public int characterReplacement2(String s, int k) {
        int max = 0, start = 0, end = 0, cur = 0;
        int[] count = new int[26];
        while (end < s.length()) {
            int index = s.charAt(end) - 'A';
            count[index]++;
            cur = Math.max(cur, count[index]);
            while (end - start + 1 - cur > k)
                count[s.charAt(start++) - 'A']--;
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }
}
