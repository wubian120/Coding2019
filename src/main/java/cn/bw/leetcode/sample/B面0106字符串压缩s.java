package cn.bw.leetcode.sample;

/**
 * @ClassName : B面0106字符串压缩s
 * @Author : Richard.Wu
 * @Date: 2020-03-16 09:22
 * @Description :
 */

public class B面0106字符串压缩s {

    public String compressString(String S) {
        int len = S.length();
        if (S == null || len <= 1) return S;

        StringBuilder sb = new StringBuilder();
        //快慢前后双指针
        int l = 0, r = 1;
        while (r < len) {
            if (S.charAt(r) != S.charAt(l)) {
                sb.append(S.charAt(l));
                sb.append((r - l) + "");
                l = r;
                r += 1;
            } else {
                r++;
            }
        }
        //最后一个相同的字符
        sb.append(S.charAt(l));
        sb.append((r - l) + "");

        //和原字符串比较长度
        return sb.length() >= len ? S : sb.toString();
    }


}
