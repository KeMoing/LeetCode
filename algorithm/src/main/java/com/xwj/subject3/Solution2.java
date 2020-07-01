package com.xwj.subject3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现
 *
 * @author xuwenjie
 * @create 2020-07-01 0:52
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 参数检查
        if (s == null || s.length() == 0) {
            return 0;
        }

        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            while (set.contains(curr)) {
                set.remove(queue.poll());
            }
            queue.offer(curr);
            set.add(curr);
            maxLen = Math.max(maxLen, queue.size());
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1));
        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3));
    }
}
