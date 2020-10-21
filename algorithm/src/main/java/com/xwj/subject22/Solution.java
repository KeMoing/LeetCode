package com.xwj.subject22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuwenjie
 * @create 2020-10-22 0:42
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 参数校验
        if (n == 0) {
            return result;
        }
        // 执行深度优先遍历，探寻可能的结果
        dfs("", n, n, result);
        return result;
    }


    /**
     * 深度优先遍历
     *
     * @param curStr
     * @param left   剩余的左括号数
     * @param right  剩余的右括号数
     * @param result 结果列表
     */
    public void dfs(String curStr, int left, int right, List<String> result) {
        // 递归终止条件
        if (left == 0 && right == 0) {
            result.add(curStr);
            return;
        }

        // 保证剩余的左括号（严格）小于剩余的右括号 —— 减枝
        if (left > right) {
            return;
        }

        // 先放置左括号
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, result);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }


}
