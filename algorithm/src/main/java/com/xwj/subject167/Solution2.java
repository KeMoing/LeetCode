package com.xwj.subject167;

import java.util.Arrays;

/**
 * 二分查找的方法
 *
 * @author xuwenjie
 * @create 2020-11-01 18:24
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        // 入参检查
        if (numbers == null || numbers.length < 2) {
            throw new RuntimeException("输入参数有误！");
        }
        int[] res = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int tmp = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (tmp > 0) {
                res[0] = i+1;
                res[1] = tmp+1;
                return res;
            }
        }

        return res;
    }

    public int binarySearch(int[] numbers, int start, int end, int target) {
        int res = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
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
