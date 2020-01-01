package cn.bw.leetcode.prac;

public class A87扰乱字符串r {


    public boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if (lenS1 != lenS2) {
            return false;
        }


        //lenS1 == lenS2;
        boolean[][][] dp = new boolean[lenS1][lenS1][lenS1 + 1];

        for (int i = 0; i < lenS1; i++) {
            for (int j = 0; j < lenS1; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        for (int len = 2; len <= lenS1; len++) {
            for (int i = 0; i <= lenS1 - len; i++) {
                for (int j = 0; j <= lenS1 - len; j++) {
                    for (int k = 1; k <= len - 1; k++) {
                        //第一种情况
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        //第二种情况
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][lenS1];
    }


    public boolean isScramble1(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        return isScramble(c1,0,c1.length-1,c2,0,c2.length-1);
    }

    private boolean isScramble(char[] c1, int start1, int end1, char[] c2, int start2, int end2) {
        int[] letters = new int[26];
        boolean isSame = true;
        for(int i=start1,j=start2;i<=end1;i++,j++){
            letters[c1[i]-'a']++;
            letters[c2[j]-'a']--;
            isSame = isSame&&c1[i]==c2[j];
        }
        if(isSame) return true;
        for(int i=0;i<26;i++){
            if(letters[i]!=0){
                return false;
            }
        }

        //why <end1
        for(int i=start1, j=start2;i<end1; i++,j++){
            if(isScramble(c1,start1,i,c2,start2,j)&&
                    isScramble(c1,i+1,end1,c2,j+1,end2)){
                return true;
            }
            if(isScramble(c1,start1,i,c2,end2-j+start2,end2)&&
                    isScramble(c1,i+1,end1,c2,start2,end2-j+start2-1)){
                return true;
            }
        }
        return false;

    }


}
