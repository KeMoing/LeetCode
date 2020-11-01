package com.xwj.subject167;

import java.util.Arrays;

/**
 * 使用双指针
 *
 * @author xuwenjie
 * @create 2020-11-01 18:57
 */
public class Solution4 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new RuntimeException("入参有误");
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }
}
