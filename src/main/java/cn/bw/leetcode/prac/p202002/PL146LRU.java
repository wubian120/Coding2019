package cn.bw.leetcode.prac.p202002;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : PL146LRU
 * @Author : Richard.Wu
 * @Date: 2020-03-27 10:12
 * @Description :
 */

public class PL146LRU {


    public PL146LRU(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;

    }

    class Node {

        int value;
        int key;

        Node pre;
        Node next;
    }

    private int size = 0;

    private int capacity;
    Map<Integer, Node> nodeMap = new HashMap<>();

    Node head = new Node();
    Node tail = new Node();

    /***
     * HashMap + 双端队列 解法
     *
     *
     */

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);

        /**
         * 取出node 前后节点，连起来
         * 再把node 放到队尾
         */
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        Node tailPre = tail.pre;
        tailPre.next = node;
        node.pre = tailPre;
        node.next = tail;
        tail.pre = node;

        return node.value;

    }

    /**
     * 看 map里是否已存在 key。
     * 如果不存在，
     * 新建，判断size 是否超出 capacity, 超出就删除队首。
     * 新建放入map, 新建node 放入队尾。size+1;
     * 如果存在,
     * 取出node，连上node 前后
     * node 放入队尾
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        Node node = nodeMap.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;

            if (size >= capacity) {

                Node headNext = head.next;
                headNext.next.pre = head;
                head.next = headNext.next;

                nodeMap.remove(headNext.key);
            }

            nodeMap.put(key, node);

            Node tailPre = tail.pre;
            tailPre.next = node;

            tail.pre = node;
            node.next = tail;
            node.pre = tailPre;
            size++;

        } else {

            node.value = value;

            Node nodePre = node.pre;
            Node nodeNext = node.next;

            nodePre.next = nodeNext;
            nodeNext.pre = nodePre;


            Node tailPre = tail.pre;
            tailPre.next = node;
            tail.pre = node;
            node.pre = tailPre;
            node.next = tail;

        }

    }


}
