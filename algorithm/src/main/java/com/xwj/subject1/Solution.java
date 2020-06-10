package com.xwj.subject1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 *      使用map存储已遍历过的数组，时间复杂度为O(n)
 * @author xuwenjie
 * @create 2020-06-11 0:09
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // map用于保存已遍历过的数
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            // 余数
            int remainder = target - nums[index];
            if (map.containsKey(remainder)) {
                return new int[]{map.get(remainder), index};
            }
            map.put(nums[index], index);
        }
        throw new IllegalArgumentException("no two number sum is target");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] resArray = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(resArray));
    }
}
