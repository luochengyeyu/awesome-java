package com.lcyy.leetcode;

import java.util.HashMap;
import java.util.Map;

class String1 {

    public static void main(String[] args) {
//        int res = new String1().lengthOfLongestSubstring("abcabcbb");
        int res = new Solution().lengthOfLongestSubstring2("abcdefgaaz");
        System.out.println(res);
    }
}

class Solution {
    /**
     * 滑动窗口 + 哈希表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

    /**
     * 动态规划 + 哈希表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}