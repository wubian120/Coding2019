package cn.bw.生产者消费者.blockingqueue;

import cn.bw.生产者消费者.Model;
import cn.bw.生产者消费者.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueModelThree implements Model {
    private final BlockingQueue<Task> queue = new LinkedBlockingDeque<>();

    private final AtomicInteger taskNo = new AtomicInteger(0);

    @Override
    public Runnable getRunnableProducer() {
        return new Producer();
    }

    @Override
    public Runnable getRunnableConsumer() {
        return new Consumer();
    }


    private class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Task t = new Task(taskNo.getAndIncrement());
                    System.out.println("Produce: Task-No " + t.no);
                    queue.put(t);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {

                    Task task = queue.take();

                    Thread.sleep(1000);
                    System.out.println("Consume: TaskNo " + task.no);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String... args) {

        BlockingQueueModelThree bqt = new BlockingQueueModelThree();

        for (int i = 0; i < 2; i++) {
            new Thread(bqt.getRunnableProducer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(bqt.getRunnableConsumer()).start();
        }

    }

}
