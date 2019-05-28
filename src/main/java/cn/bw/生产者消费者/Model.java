package cn.bw.生产者消费者;

public interface Model {

    Runnable getRunnableConsumer();
    Runnable getRunnableProducer();

}
