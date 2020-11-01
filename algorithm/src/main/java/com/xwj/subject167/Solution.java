package com.xwj.subject167;

import java.util.Arrays;

/**
 * 暴力解法
 *
 * @author xuwenjie
 * @create 2020-11-01 18:19
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new RuntimeException("输入参数有误！");
        }

        int[] res = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }
}
