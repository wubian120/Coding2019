package cn.bw.生产者消费者.blockingqueue;

public interface TaskFactory {

    Runnable getConsummer();

    Runnable getProducer();

}
