package cn.bw.designpattern.单例模式;

/**
 * @ClassName : 饿汉单例
 * @Author : Richard.Wu
 * @Date: 2020-04-28 10:36
 * @Description :
 */

public class 饿汉单例 {

    private static 饿汉单例 singleton=new 饿汉单例();

    private 饿汉单例(){}

    public static 饿汉单例 getInstance(){
        return singleton;
    }

}
