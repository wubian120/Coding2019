package cn.bw.designpattern.单例模式;

/**
 * @ClassName : 静态内部类
 * @Author : Richard.Wu
 * @Date: 2020-04-28 10:42
 * @Description :
 */

public class 静态内部类 {

    private static class SingletonHolder{
        private static final 静态内部类 singleton= new 静态内部类();

    }

    private 静态内部类(){}

    public static final 静态内部类 getInstance(){
        return SingletonHolder.singleton;
    }

}
