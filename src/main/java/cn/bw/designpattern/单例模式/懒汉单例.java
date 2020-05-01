package cn.bw.designpattern.单例模式;

/**
 * @ClassName : 懒汉单例
 * @Author : Richard.Wu
 * @Date: 2020-04-28 10:28
 * @Description :
 */

public class 懒汉单例 {

    private static 懒汉单例 singleton;

    private 懒汉单例(){}

    public static synchronized 懒汉单例 getInstance(){
        if(singleton==null){
             singleton = new 懒汉单例();
        }
        return singleton;
    }





}
