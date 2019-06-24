package cn.bw.生产者消费者;

/**
 * 工厂接口
 */
public interface Model {

    Runnable getRunnableConsumer();
    Runnable getRunnableProducer();

}
