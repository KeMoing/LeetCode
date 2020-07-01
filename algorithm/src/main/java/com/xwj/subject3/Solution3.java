package com.xwj.subject3;

/**
 * 滑动窗口
 *
 * @author xuwenjie
 * @create 2020-07-02 1:13
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        // 参数检查
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        Integer[] cacheArr = new Integer[128];
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            if (cacheArr[curr] != null) {
                start = Math.max(start, cacheArr[curr] + 1);
            }
            cacheArr[curr] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1));
        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3));
    }
}
