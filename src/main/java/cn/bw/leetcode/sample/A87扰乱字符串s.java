package cn.bw.leetcode.sample;

/***
 *
 *
 */
public class A87扰乱字符串s {

    public boolean isScramble(String s1, String s2) {
        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();
        return isScramble(v1, 0, v1.length - 1, v2, 0, v2.length - 1);
    }

    private boolean isScramble(char[] v1, int start1, int end1, char[] v2, int start2, int end2) {
        int[] letters = new int[26];
        boolean isSame = true;
        for (int i = start1, j = start2; i <= end1; i++, j++) {
            letters[v1[i] - 'a']++;
            letters[v2[j] - 'a']--;
            isSame = isSame && v1[i] == v2[j];
        }
        if (isSame) return true;
        for (int i = 0; i < 26; i++) if (letters[i] != 0) return false;
        for (int i = start1, j = start2; i < end1; i++, j++) {
            if (isScramble(v1, start1, i, v2, start2, j)
                    && isScramble(v1, i + 1, end1, v2, j + 1, end2))
                return true;
            if (isScramble(v1, start1, i, v2, end2 - j + start2, end2)
                    && isScramble(v1, i + 1, end1, v2, start2, end2 - j + start2 - 1))
                return true;
        }
        return false;
    }

    //动态规划
    public boolean isScramble2(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        //初始化单个字符的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        //枚举长度2～n
        for (int len = 2; len <= n; len++) {
            //枚举S中的起点位置
            for (int i = 0; i <= n - len; i++) {

                //枚举T中的起点位置
                for (int j = 0; j <= n - len; j++) {

                    //枚举划分位置
                    for (int k = 1; k <= len - 1; k++) {

                        //第一种情况：S1->T1,S2->T2
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        //第二种情况：S1->T2,S2->T1
                        //S1起点i，T2起点j + 前面那段长度len-k，S2起点i+前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }







}
