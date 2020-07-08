package cn.bw.leetcode.sample.IO;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : IO1611
 * @Author : Richard.Wu
 * @Date: 2020-07-08 10:22
 * @Description :
 * <p>
 * 程序员面试金典   16.11 跳水板
 */

public class IO1611 {

    public int[] divingBoard(int shorter, int longer, int k) {

        List<Integer> results=new LinkedList<>();

        if (k == 0) {
            return results.stream().mapToInt(Integer::intValue).toArray();
        }

        if(longer==shorter){
            results.add(longer*k);
            return results.stream().mapToInt(Integer::intValue).toArray();
        }

        for(int i=0;i<=k;i++){
            results.add((k*shorter)+(longer-shorter)*i);
        }


        return results.stream().mapToInt(Integer::intValue).toArray();

    }
}
