package cn.bw.leetcode;

import cn.bw.utils.FilePathCount;

/**
 * @ClassName : LeetcodeFileCounter
 * @Author : Richard.Wu
 * @Date: 2020-03-10 11:00
 * @Description :
 */

public class LeetcodeFileCounter {

    String pracPath = "/Users/richard.wu/coding/coding2019/src/main/java/cn/bw/leetcode/sample";

    String aPath = "./src/main/java/cn/bw/leetcode/sample";

    public void pracSampleCodeFiles(){

        int count= FilePathCount.filesCount(aPath);

        System.out.println(count);

    }


    public static void main(String...args){


        LeetcodeFileCounter lfc = new LeetcodeFileCounter();
        lfc.pracSampleCodeFiles();





    }


}
