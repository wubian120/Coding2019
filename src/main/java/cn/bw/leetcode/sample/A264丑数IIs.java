package cn.bw.leetcode.sample;

/**
 * @ClassName : A264丑数IIs
 * @Author : Richard.Wu
 * @Date: 2020-06-25 22:26
 * @Description :
 */

public class A264丑数IIs {
    class Ugly{
        public  int[] nums = new int[1690];
        Ugly(){
            nums[0]=1;
            int ugly, i2=0,i3=0,i5=0;

            for(int i=1;i<1690;i++){
                int v2 = nums[i2]*2;
                int v3 = nums[i3]*3;
                int v5 = nums[i5]*5;
                ugly = Math.min(v2,Math.min(v3,v5));
                nums[i]=ugly;

                if(ugly==v2) i2++;
                if(ugly==v3) i3++;
                if(ugly==v5) i5++;
            }






        }

    }

    Ugly u = new Ugly();

    public int nthUglyNumber(int n) {

        return u.nums[n-1];
    }
}
