package cn.bw.生产者消费者.blockingqueue;

import cn.bw.生产者消费者.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueModelOne implements Model {

    private final BlockingQueue<Task> workingQueue;

    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModelOne(int capacity){
        workingQueue = new LinkedBlockingDeque<Task>(capacity);
    }

    @Override
    public Runnable getRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable getRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable{
        @Override
        public void consume() throws InterruptedException{
            Task task = workingQueue.take();

            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.no);
        }
    }

    private class ProducerImpl extends AbstractProducer implements Producer,Runnable{
        @Override
        public void produce() throws InterruptedException{
            Thread.sleep((long)(Math.random()* 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            System.out.println("Produce: "+ task.no);
            workingQueue.put(task);
        }
    }

    public  static void main(String...args){

        Model model = new BlockingQueueModelOne(5);

        for(int i=0;i<10;i++){
            new Thread(model.getRunnableProducer()).start();
        }

        for(int i=0;i<3;i++){
            new Thread(model.getRunnableConsumer()).start();
        }


        System.out.println("end");
    }
}
