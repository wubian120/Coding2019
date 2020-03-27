package cn.bw.生产者消费者.blockingqueue;

import cn.bw.生产者消费者.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/6/21 14:22
 */
public class BlockingQueueMTwo {

    private final BlockingQueue<Task> queue;

    public BlockingQueueMTwo(int capacity) {
        queue = new LinkedBlockingDeque<>(capacity);


    }


    public static class Task {
        private int id;

        public Task(int id){
            this.id=id;
        }

        public int getId() {
            return id;
        }
    }

}
