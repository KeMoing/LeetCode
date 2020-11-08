package com.xwj.subject252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xuwenjie
 * @create 2020-11-08 15:35
 */
public class Solution {

    /**
     * 思路：
     *      因为一个人在同一时刻只能参加一个会议，
     *      因此题目实质是判断是否存在重叠区间，这个简单，
     *      将区间按照会议开始时间进行排序，然后遍历一遍判断即可。
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // 入参检查
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        // 将区间按照会议开始实现升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = intervals.length;
        // 遍历会议，如果下一个会议在前一个会议结束之前就开始了，返回 false。
        for (int i = 0; i < len - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{7, 10}, {2, 4}};
        boolean result = solution.canAttendMeetings(intervals);

        System.out.println(result);
    }
}
