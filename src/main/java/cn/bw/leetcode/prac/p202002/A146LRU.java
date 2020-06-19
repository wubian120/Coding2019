package cn.bw.leetcode.prac.p202002;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : A146LRU
 * @Author : Richard.Wu
 * @Date: 2020-06-13 12:01
 * @Description :
 */

public class A146LRU {


    class Node{
        int key;
        int value;
        Node pre;
        Node next;
    }

    private int capacity=0;
    private int size=0;

    Node head = new Node();
    Node tail = new Node();

    Map<Integer,Node> map = new HashMap<>();

    public A146LRU(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre =head;
    }

    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        node.next.pre = node.pre;
        node.pre.next = node.next;

        Node oldTailPre = tail.pre;

        oldTailPre.next = node;
        node.next = tail;
        node.pre = oldTailPre;
        tail.pre = node;

        return node.value;

    }

    public void put(int key, int value) {

        Node node = map.get(key);

        if(node==null){
            //new
            node = new Node();
            node.key=key;
            node.value = value;




            map.put(key,node);
            size++;

            Node oldTailPre = tail.pre;
            oldTailPre.next = node;
            node.pre = oldTailPre;
            node.next = tail;
            tail.pre = node;



            if(size>=capacity){

                Node oldHeadNext = head.next;
                head.next = oldHeadNext.next;
                oldHeadNext.next.pre = head;

                map.remove(oldHeadNext.key);

            }




        }else {

            node.value = value;

            node.pre.next = node.next;
            node.next.pre = node.pre;

            Node oldTailPre =tail.pre;
            oldTailPre.next = node;
            node.pre = oldTailPre;
            node.next = tail;
            tail.pre = node;
        }

    }


    public static void main(String[] args){

        A146LRU a = new A146LRU(2);

        a.put(1,1);
        a.put(2,2);

        int r = a.get(1);

        a.put(3,3);

        r = a.get(2);

        System.out.println("end");



    }


}
