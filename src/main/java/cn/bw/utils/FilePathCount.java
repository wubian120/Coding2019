package cn.bw.utils;

import java.io.File;

/**
 * @ClassName : FilePathCount
 * @Author : Richard.Wu
 * @Date: 2020-03-10 10:55
 * @Description :
 */

public class FilePathCount {


    public static int filesCount(String path){
        File dir = new File(path);
        if(!dir.exists()){
            System.out.println("Path: "+path+" is not exists!");
            return 0;
        }

        if(!dir.isDirectory()){
            System.out.println("Path: "+path+" is not a directory.");
        }

        String[] files=dir.list();

//        for(String file:files){
//            System.out.println("File: "+file);
//        }

        return files.length;

    }
}
