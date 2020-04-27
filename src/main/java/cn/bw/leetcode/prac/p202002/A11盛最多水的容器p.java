package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A11盛最多水的容器p
 * @Author : Richard.Wu
 * @Date: 2020-04-19 10:58
 * @Description :
 */

public class A11盛最多水的容器p {


    public int maxArea(int[] height) {

        int right =height.length-1, left = 0;
        int maxArea = 0;

        while(left<right){

            int w = right-left;
            int h = 0;
            if(height[left]<height[right]){
                h=height[left];
                left++;
            }else{
                h=height[right];
                right--;
            }

            maxArea = Math.max(maxArea, w*h);
        }

        return maxArea;

    }


    public static void main(String[] args){
        int[] height={1,8,6,2,5,4,8,3,7};

        A11盛最多水的容器p a = new A11盛最多水的容器p();

        int area= a.maxArea(height);

        System.out.println(area);

    }
}
