package com.xwj.subject167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 借助哈希表
 *
 * @author xuwenjie
 * @create 2020-11-01 18:42
 */
public class Solution3 {

    private int remainder;

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new RuntimeException("输入参数有误！");
        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            remainder = target - numbers[i];
            if (hashMap.containsKey(remainder)) {
                return new int[]{hashMap.get(remainder) + 1, i + 1};
            }
            hashMap.put(numbers[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }
}
