package cn.bw.leetcode.sample;

/**
 * @ClassName : A67二进制求和s
 * @Author : Richard.Wu
 * @Date: 2020-06-25 23:08
 * @Description :
 */

public class A67二进制求和s {
    public String addBinary(String a, String b) {
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;

        int carrier = 0;
        StringBuilder builder = new StringBuilder();

        while (idxA >= 0 || idxB >= 0) {
            int ia = idxA >= 0 ? a.charAt(idxA--) - '0' : 0;
            int ib = idxB >= 0 ? b.charAt(idxB--) - '0' : 0;

            int r = ia + ib + carrier;

            if (r >= 3) {
                carrier = 1;
                r = 1;
            } else if (r == 2) {
                carrier = 1;
                r = 0;
            } else {
                carrier = 0;
            }

            builder.insert(0,""+r);
        }

        if(carrier==1){
            builder.insert(0,"1");
        }

        return builder.toString();

    }
}
