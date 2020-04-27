package cn.bw.生产者消费者.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : BlockingQueueFinal
 * @Author : Richard.Wu
 * @Date: 2020-03-27 09:20
 * @Description :
 */

public class BlockingQueueFinal implements TaskFactory {

    private final AtomicInteger taskNo = new AtomicInteger(0);
    private final BlockingQueue<Task> workingQueue = new LinkedBlockingDeque<>();


    @Override
    public Runnable getConsummer() {
        return new Consumer();
    }

    @Override
    public Runnable getProducer() {
        return new Producer();
    }


    public static class Task {
        public int taskNo;

        public Task(int no) {
            taskNo = no;
        }

    }

    private class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3 * 1000);
                    Task task = new Task(taskNo.getAndIncrement());
                    System.out.println("Produce-Task: " + task.taskNo);
                    workingQueue.put(task);
                } catch (InterruptedException e) {
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

                    Task task = workingQueue.take();
                    Thread.sleep(10 * 1000);
                    System.out.println("Consume-Task:" + task.taskNo);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String... args) {

        BlockingQueueFinal bf = new BlockingQueueFinal();

        for (int i = 0; i < 5; i++) {
            new Thread(bf.getProducer()).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(bf.getConsummer()).start();
        }


    }


}

interface TaskFactory {

    Runnable getConsummer();

    Runnable getProducer();

}