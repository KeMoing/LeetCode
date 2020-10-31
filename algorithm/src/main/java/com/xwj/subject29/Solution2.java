package com.xwj.subject29;

/**
 * 移位运算
 *
 * @author xuwenjie
 * @create 2020-10-31 16:20
 */
public class Solution2 {

    public int divide(int dividend, int divisor) {
        // 入参检查
        if (divisor == 0) {
            throw new RuntimeException("两数相除，除数不能为0");
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            isPositive = true;
        }

        // 将被除数和除数使用负数表示，避免边界问题
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int result = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int step = 1;
            while (dividend - temp < temp) {
                temp <<= 1;
                step <<= 1;
            }
            dividend -= temp;
            result += step;
        }

        // 结果为负数
        if (isPositive == false) {
            result = -result;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.divide(10,3));
        System.out.println(solution.divide(7,-3));
    }

}
