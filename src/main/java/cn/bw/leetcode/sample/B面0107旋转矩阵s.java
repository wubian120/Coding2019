package cn.bw.leetcode.sample;

/**
 * @ClassName : B面0107旋转矩阵s
 * @Author : Richard.Wu
 * @Date: 2020-03-28 12:24
 * @Description :
 *
 * nextX = currentY
 * nextY = N-1-currentX
 *
 * 最内的循环  最先交换 四个角的元素  [0,2] [2,2] [2,0] [0,0]
 * 第二层循环  起始列+1，即 由[0,0]-> [0,1] [1,2],[]
 *
 * 最内循环 第一轮 四个角
 * 1,2,3    1,2,1    1,2,1    1,2,1    7,2,1
 * 4,5,6 -> 4,5,6 -> 4,5,6 -> 4,5,6 -> 4,5,6
 * 7,8,8    7,8,9    7,8,3    9,8,3    9,8,3
 *
 */

public class B面0107旋转矩阵s {


    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        int level = (N + 1) / 2;
        int last = N - 1;
        int currentX, currentY, nextX, nextY, val;
        for (int l = 0; l < level; l++) {
            for (int i = l; i < last; i++) {
                //当前结点坐标为 l , i
                currentX = l;
                currentY = i;
                val = matrix[currentX][currentY];
                for (int j = 0; j < 4; j++) {
                    nextX = currentY;
                    nextY = N - 1 - currentX;
                    //交换 val 和 matrix[next][next]的值
                    int temp = matrix[nextX][nextY];
                    matrix[nextX][nextY] = val;
                    val = temp;
                    currentX = nextX;
                    currentY = nextY;
                }
            }
            //往内走，
            last -= 1;
        }


    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};



        B面0107旋转矩阵s.rotate(matrix);

        System.out.println("end");


    }

}
