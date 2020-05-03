package cn.bw.leetcode.sample;

/**
 * @ClassName : A38外观数列s
 * @Author : Richard.Wu
 * @Date: 2020-04-30 22:38
 * @Description :
 */

public class A38外观数列s {

    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        int pre = 0;
        int cur = 1;
        if (n == 1)
            return "1";
        String str = countAndSay(n - 1);

        for (cur = 1; cur < str.length(); cur++) {

            // 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
            if (str.charAt(pre) != str.charAt(cur)) {
                int count = cur - pre;
                s.append(count).append(str.charAt(pre));
                pre = cur;
            }
        }

        // 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
        if (pre != cur) {
            int count = cur - pre;
            s.append(count).append(str.charAt(pre));
        }

        return s.toString();
    }


    public static void main(String[] args) {

        int i = 4;

        A38外观数列s a = new A38外观数列s();
        String result = a.countAndSay(i);

        System.out.println("end");

    }

}
