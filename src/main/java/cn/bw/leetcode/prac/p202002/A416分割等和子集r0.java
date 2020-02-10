package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A416分割等和子集r0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-08 13:21
 */

public class A416分割等和子集r0 {


    public boolean canPartition0(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 奇偶判断， 如果为奇数，则必然 为false
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];


        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }else {
                    dp[i][j]=false;
                }
            }
        }
        return dp[len - 1][target];

    }

    public boolean canPartition(int[] nums) {

        int sum=0;
        for(int i:nums){
            sum +=i;
        }

        if(sum%2 ==1){
            return false;
        }

        int half=sum/2;

        //dp[i] nums数组 能够组成 和为i的 状态。
        boolean[] dp=new boolean[half+1];
        dp[0]=true;

        for(int num:nums){
            for(int i=half;i>=num;i--){
                //dp[i-num] 表示 可以找到 和为 i-num的集合
                if(dp[i-num]){
                    dp[i]=true;
                }
            }
        }
        return  dp[half];

    }

    public static void main(String...arg){

        int[] nums={1,5,11,5};

        A416分割等和子集r0 a = new A416分割等和子集r0();
        boolean result = a.canPartition(nums);

        System.out.println(result);


    }
}
