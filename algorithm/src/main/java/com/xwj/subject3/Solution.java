package com.xwj.subject3;

import java.util.HashSet;

/**
 * 暴力解法
 *
 * @author xuwenjie
 * @create 2020-06-30 0:26
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 入参检查
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                sb.append(s.charAt(j));
            }
            if (sb.toString().length() > maxLen) {
                maxLen = sb.toString().length();
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "a";
        System.out.println(solution.lengthOfLongestSubstring(s1));
        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3));
    }
}
