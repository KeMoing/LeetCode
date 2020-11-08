package com.xwj.subject57;

import java.util.Arrays;

/**
 * @author xuwenjie
 * @create 2020-11-08 16:25
 */
public class Solution {

    /**
     * 思路：
     * 本题中的区间已经按照起始端点升序排列，因此我们直接遍历区间列表，寻找新区间的插入位置即可。具体步骤如下：
     * <p>
     * 首先将新区间左边且相离的区间加入结果集（遍历时，如果当前区间的结束位置小于新区间的开始位置，说明当前区间在新区间的左边且相离）；
     * <p>
     * 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，将最终合并后的新区间加入结果集；
     * <p>
     * 最后将新区间右边且相离的区间加入结果集。
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 入参检查
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        int len = intervals.length;
        // 初始化结果数组
        int[][] resArr = new int[len + 1][2];
        int index = 0;

        int i = 0;
        // 遍历区间列表：
        // 首先将新区间左边且相离的区间加入结果集
        while (i < len && intervals[i][1] < newInterval[0]) {
            resArr[index++] = intervals[i++];
        }

        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        resArr[index++] = newInterval;

        while (i < len) {
            resArr[index++] = intervals[i++];
        }

        return Arrays.copyOfRange(resArr, 0, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] resArr = solution.insert(intervals, newInterval);
        for (int i = 0; i < resArr.length; i++) {
            System.out.println(Arrays.toString(resArr[i]));
        }
    }
}
