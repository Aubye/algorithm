package com.app.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Leetcode_5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     */
    public static void main(String[] args) {
        String str = "aacdefcaa";
        String result = longestPalindrome(str);
        String str1 = "aacdefcaa";
        String result1 = longestPalindrome1(str1);
        log.info("finish");
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static String longestPalindrome1(String s) {
        if ("".equals(s)) {
            return s;
        }
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        // s[i]=s[j] and (dp[i+1]=dp[j-1]) and (j-1)-(i+1)+1 < 2 -> j-i<3
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
