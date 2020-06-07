package cn.bw.leetcode.sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : A128最长连续序列s
 * @Author : Richard.Wu
 * @Date: 2020-06-06 09:56
 * @Description :
 */

public class A128最长连续序列s {




    // hash 解法
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        // numSet.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for(int i: nums){
            numSet.add(i);
        }
        int result = 0;
        for (int i : nums) {
            if (numSet.remove(i)) {
                int pre = i - 1, next = i + 1;
                while (numSet.remove(pre))
                    --pre;
                while (numSet.remove(next))
                    ++next;
                result = Math.max(result, next - pre - 1);
            }
        }
        return result;

    }

    /**
     * 并查集解法
     * @param nums
     * @return
     */

    public int longestConsecutive1(int[] nums) {
        if(nums==null||nums.length==0) return 0;

        UnionFind uf = new UnionFind(nums);

        for(int i=0;i<nums.length;i++){
            //查找当前节点的上一个节点
            if(uf.fatherMap.containsKey(nums[i]-1)){
                uf.union(nums[i]-1,nums[i]);
            }
        }
        return uf.max;
    }
    public class UnionFind{
        int max = 1;
        HashMap<Integer,Integer> fatherMap;
        HashMap<Integer,Integer> sizeMap;

        public UnionFind(int[] nums){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for(int val: nums){
                fatherMap.put(val,val);
                sizeMap.put(val,1);
            }
        }

        //找到父节点并优化结构
        public int findFather(int val){
            int father = fatherMap.get(val);
            if(father != val){
                father = findFather(father);
            }
            fatherMap.put(val,father);
            return father;
        }

        public void union(int a,int b){
            int aFather = findFather(a);
            int bFather = findFather(b);
            if(aFather != bFather){
                int  aFatherSize = sizeMap.get(aFather);
                int  bFatherSize = sizeMap.get(bFather);

                fatherMap.put(aFather,bFather);
                sizeMap.put(bFather,aFatherSize + bFatherSize);

                max = Math.max(max,aFatherSize + bFatherSize);
            }
        }
    }







}
