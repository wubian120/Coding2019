package cn.bw.designpattern.单例模式;

/**
 * @ClassName : 双重校验锁
 * @Author : Richard.Wu
 * @Date: 2020-04-28 10:38
 * @Description :
 */

public class 双重校验锁 {


    private volatile static 双重校验锁 singleton;

    private 双重校验锁(){}

    public static 双重校验锁 getSingleton(){
        if(singleton==null){
            synchronized (双重校验锁.class){
                if(singleton==null){
                    singleton = new 双重校验锁();
                }
            }
        }
        return singleton;
    }

}
