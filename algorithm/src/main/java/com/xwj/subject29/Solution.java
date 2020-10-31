package com.xwj.subject29;

/**
 * 暴力解法
 *
 * @author xuwenjie
 * @create 2020-10-31 15:56
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        // 参数校验
        if (divisor == 0) {
            throw new RuntimeException("两数相除，除数不能为0");
        }
        // 注意：需要考虑边界问题
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (dividend == 0 || divisor == Integer.MIN_VALUE) {
            return 0;
        }

        boolean isPositive = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            isPositive = true;
        } else {
            isPositive = false;

        }

        // 使用负数进行下面的操作，防止精度问题
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }


        // 商
        int quotient = 0;
        int step = Math.abs(divisor);
        while (dividend <= divisor) {
            dividend = dividend + step;
            quotient++;
        }

        // 返回结果
        if (isPositive) {
            return quotient;
        } else {
            return -quotient;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(1, 1));
    }
}
