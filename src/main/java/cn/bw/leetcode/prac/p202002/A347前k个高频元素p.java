package cn.bw.leetcode.prac.p202002;

import java.util.*;

/**
 * @ClassName : A347前k个高频元素p
 * @Author : Richard.Wu
 * @Date: 2020-06-07 11:48
 * @Description :
 */

public class A347前k个高频元素p {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mapFre= new HashMap<>();

        for(int num:nums){
            if(mapFre.containsKey(num)){
                mapFre.put(num,mapFre.get(num)+1);
            }else {
                mapFre.put(num,1);
            }
        }

        PriorityQueue<Integer> heapFre = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  mapFre.get(o1)-mapFre.get(o2);
            }
        });

        for(int key:mapFre.keySet()){

            if (heapFre.size()<k){
                heapFre.add(key);
            }else if(mapFre.get(key)>mapFre.get(heapFre.peek())){
                heapFre.poll();
                heapFre.add(key);
            }
        }

        List<Integer> reList=new LinkedList<>();

        while (!heapFre.isEmpty()){
            reList.add(heapFre.poll());
        }

        return reList.stream().mapToInt(Integer::intValue).toArray();

    }

    public  static void main(String[] args){

        int[] nums={5,3,1,1,1,3,73,1};
        int k = 2;

        A347前k个高频元素p a = new A347前k个高频元素p();

        int[] res = a.topKFrequent(nums,k);


        System.out.println("end");

    }

}
