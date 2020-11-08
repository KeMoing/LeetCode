package com.xwj.subject56;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xuwenjie
 * @create 2020-11-08 16:02
 */
public class Solution {

    /**
     * 思路
     * 首先对区间按照起始端点进行升序排序，然后逐个判断当前区间是否与前一个区间重叠，
     * 如果不重叠的话将当前区间直接加入结果集，反之如果重叠的话，就将当前区间与前一个区间进行合并。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 入参检查
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 先按照区间起始位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = intervals.length;
        int[][] resArr = new int[len][2];
        int index = -1;

        // 遍历区间
        for (int i = 0; i < len; i++) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，说明不重叠。
            // 则不合并，直接将当前区间加入结果数组。
            if (index == -1 || intervals[i][0] > resArr[index][1]) {
                index++;
                resArr[index] = intervals[i];
            } else {
                // 反之说明重叠，则将当前区间合并至结果数组的最后区间
                resArr[index][1] = Math.max(resArr[index][1], intervals[i][1]);
            }
        }

        return Arrays.copyOfRange(resArr, 0, index + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] resArr = solution.merge(intervals);
        for (int i = 0; i < resArr.length; i++) {
            System.out.println(Arrays.toString(resArr[i]));
        }

    }
}
